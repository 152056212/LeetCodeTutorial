package com.nsc.sjg;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class JUnit_JZOffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[][] visited = new boolean[2][2];
		JUnit_JZOffer geohashTest = new JUnit_JZOffer();
		char[][] board = { { 'a' } };
		// System.out.println(geohashTest.exist(board, "ab"));
		// 大数1.00000

		// BigDecimal test01 = new BigDecimal("1.1");
		// int resTest01 = test01.compareTo(new
		// BigDecimal("1.10000000000000000000000000000000000000001"));
		// System.out.println(resTest01);
		// BigDecimal test04 = new BigDecimal("4.0");
		// BigDecimal test036 = new BigDecimal("3.6");
		// System.out.println(test04.subtract(test036));
		// System.out.println(4.0 - 3.6);

		int[] preOrder = new int[] { 3, 9, 20, 15, 7 };
		int[] inOrder = new int[] { 3, 9, 20, 15, 7 };
		// buildTree(preOrder, inOrder);
		splitN(7, 1);

		// double powTest01 = geohashTest.myPow(2.00000,10);
		// System.out.println(powTest01);

	}

	public static void buildTree(int[] preOrder, int[] inOrder) {

		TreeNode node = dfsBuildTree(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
		preOrderTree(node);
	}

	public static TreeNode dfsBuildTree(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight) {
		if (preLeft >= preOrder.length || inLeft >= inOrder.length || preLeft > preRight || inLeft > inRight) {
			return null;
		}

		int value = preOrder[preLeft];
		TreeNode root = new TreeNode(value);

		int count = inLeft;
		while (inOrder[count] != value) {
			count++; 
		}
		count -= inLeft;

		root.left = dfsBuildTree(preOrder, inOrder, preLeft + 1, preLeft + count, inLeft, inLeft + count - 1);
		root.right = dfsBuildTree(preOrder, inOrder, preLeft + 1 + count, preRight, inLeft + count + 1, inRight);
		return root;

	}

	// JZ03判断重复数字
	public static int findRepeatNumber(int[] nums) {
		int n = nums.length;
		for (int num : nums) {
			if (num < 0 || num >= n) {
				return -1;
			}
		}
		for (int i = 0; i < n; i++) {
			while (nums[i] != i && nums[nums[i]] != nums[i]) {
				int temp = nums[i];
				nums[i] = nums[nums[i]];
				nums[temp] = temp;
			}
			if (nums[i] != i && nums[nums[i]] == nums[i]) {
				return nums[i];
			}
		}
		return -1;
	}

	/**
	 * JZ04在一个 n * m
	 * 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，
	 * 判断数组中是否含有该整数。 现有矩阵 matrix 如下：
	 * 
	 * [ [1, 4, 7, 11, 15], [2, 5, 8, 12, 19], [3, 6, 9, 16, 22], [10, 13, 14,
	 * 17, 24], [18, 21, 23, 26, 30] ] 给定 target = 5，返回 true。
	 * 
	 * 给定 target = 20，返回 false。
	 * 
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param matrix
	 * @param target
	 * @return
	 */
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0) {
			return false;
		}
		for (int row = 0, rLen = matrix.length, col = matrix[0].length - 1; row < rLen && col >= 0;) {
			if (matrix[row][col] == target) {
				return true;
			} else {
				if (matrix[row][col] > target) {
					col--;
				} else {
					row++;
				}
			}
		}
		return false;
	}

	/**
	 * JZ05请实现一个函数，把字符串 s 中的每个空格替换成"%20"。 示例 1： 输入：s = "We are happy."
	 * 输出："We%20are%20happy. 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param s
	 * @return
	 */
	public String replaceSpace(String s) {
		int f = 0, w = 0;
		if (s == null) {
			return "";
		} else {
			int oriLen = s.length(), newLen = 0;
			for (int i = 0; i < oriLen; i++) {
				if (s.charAt(i) == ' ') {
					newLen += 2;
				}
			}
			char[] newStr = new char[oriLen + newLen];
			for (int i = 0, j = 0; i < oriLen; i++) {
				if (s.charAt(i) == ' ') {
					newStr[j++] = '%';
					newStr[j++] = '2';
					newStr[j++] = '0';
				} else {
					newStr[j++] = s.charAt(i);
				}
			}
			return new String(newStr, 0, oriLen + newLen);
		}
	}

	/**
	 * JZ08二叉树的下一个节点
	 * 
	 * @param p
	 * @return
	 */
	public TreeNode inOrderSuccessor(TreeNode p) {

		// 当前节点有右孩子
		if (p.right != null) {
			p = p.right;
			while (p.left != null) {
				p = p.left;
			}
			return p;
		} else {
			// 当前节点没有右孩子
			while (p.father != null) {
				if (p == p.father.left) {
					return p.father;
				}
				p = p.father;
			}
		}
		return p;

	}

	/**
	 * JZ10.1斐波那契数列的定义如下： F(0) = 0,   F(1) = 1 F(N) = F(N - 1) + F(N - 2), 其中 N
	 * > 1. 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。 答案需要取模
	 * 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param n
	 * @return
	 */
	public int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		int first = 0, second = 1;
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = (first + second) % 1000000007;
			first = second % 1000000007;
			second = result;
		}
		return result;
	}

	/**
	 * JZ10.2青蛙跳台阶问题 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。 答案需要取模
	 * 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。 f(n) = f(n-1) + f(n-2)
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param n
	 * @return
	 */
	public int numWays(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 1;
		int first = 1, second = 1;
		int result = 0;
		for (int i = 2; i <= n; i++) {
			result = (first + second) % 1000000007;
			first = second % 1000000007;
			second = result;
		}
		return result;
	}

	/**
	 * JZ11把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [
	 * 3,4, 5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
	 * 
	 * 示例 1：
	 * 
	 * 输入：[3,4,5,1,2] 输出：1 示例 2：
	 * 
	 * 输入：[2,2,2,0,1] 输出：0
	 * 
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-
	 * lcof 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * @param numbers
	 * @return
	 */
	public int minArray(int[] numbers) {
		int low = 0, high = numbers.length - 1;
		if ((numbers[low] <= numbers[high] && numbers.length == 2) || low == high) {
			return numbers[low];
		}
		int mid = 0;
		while (low < high) {
			mid = (low + high) / 2;
			if (numbers[low] > numbers[high]) {
				// 头 > 尾
				if (numbers[low] > numbers[mid] && numbers[mid] > numbers[high]) {
					// 头 > 中 > 尾
					low = mid;
				} else {
					// 顺序查找
					low++;
				}

				if (high - low < 2) {
					return numbers[high] > numbers[low] ? numbers[low] : numbers[high];
				}
			} else {
				// 头 = 尾
				if (numbers[low] == numbers[high]) {
					if (numbers[low] < numbers[mid]) {
						// 头 < 中(找大头)
						low = mid;
					} else {
						// 头 > 中(找大头)
						if (numbers[low] > numbers[mid]) {
							high = mid;
						} else {
							// 顺序查找
							low++;
						}

					}

					if (low == high) {
						return numbers[high];
					}
				} else {
					// 头 < 尾
					return numbers[low];
				}

			}
		}
		return 0;
	}

	/**
	 * JZ12矩阵中的路径
	 * 
	 * @param board
	 * @param word
	 * @return
	 */
	public boolean exist(char[][] board, String word) {
		if (board.length == 0 || word == null) {
			return false;
		}
		int wordIdx = 0;
		int lenRow = board.length;
		int lenCol = board[0].length;
		// 默认值false
		boolean[][] visited = new boolean[lenRow][lenCol];
		for (int i = 0; i < lenRow; i++) {
			for (int j = 0; j < lenCol; j++) {
				if (hasPathCore(board, word, wordIdx, i, j, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * board: 矩阵 word: 路径 wordIdx：路径状态 rowId： 当前矩阵位置——行坐标 colId: 当前矩阵位置——列坐标
	 */
	public boolean hasPathCore(char[][] board, String word, int wordIdx, int rowId, int colId, boolean[][] visited) {

		// 路径末尾
		if (word.length() == wordIdx) {
			return true;
		}
		int rowLen = board.length, colLen = board[0].length;
		boolean hasPath = false;
		if (rowId >= 0 && rowId < rowLen && colId >= 0 && colId < colLen && board[rowId][colId] == word.charAt(wordIdx)
				&& visited[rowId][colId] == false) {
			// 相匹配且未访问
			wordIdx++;
			visited[rowId][colId] = true;
			// 东南西北
			hasPath = hasPathCore(board, word, wordIdx, rowId, colId - 1, visited)
					|| hasPathCore(board, word, wordIdx, rowId - 1, colId, visited)
					|| hasPathCore(board, word, wordIdx, rowId, colId + 1, visited)
					|| hasPathCore(board, word, wordIdx, rowId + 1, colId, visited);
			if (hasPath == false) {
				// 回退，重新尝试
				wordIdx--;
				visited[rowId][colId] = false;
			}

		}

		return hasPath;
	}

	/**
	 * JZ14.1剪绳子 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为
	 * k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1]
	 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
	 * 
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。 f(n) = max( f(i)*f(n-i) )
	 * 
	 * @param n
	 * @return
	 */
	public int cuttingRope(int n) {
		if (n < 2) {
			return 0;
		}
		if (n == 2)
			return 1;
		if (n == 3) {
			return 2;
		}

		// int timesOf3 = n/3;
		// //注意：余数为1，即剪完最后一段长度为3的绳子，会剩下一段长度为1的绳子，此时不应该采取此减法
		// //应当将最后一段长度为4的绳子减为2+2
		// if(n - timesOf3*3 == 1){
		// timesOf3 = timesOf3 - 1;
		// }
		//
		// //n - timesOf3*3 = 0，2，4
		// int timesOf2 = (n - timesOf3*3)/2;
		// return (int)Math.pow(3, timesOf3)*(int)Math.pow(2, timesOf2);

		int[] products = new int[n + 1];
		products[0] = 0;
		products[1] = 1;
		products[2] = 2;
		products[3] = 3;
		int max = 0;
		for (int i = 4; i <= n; i++) {
			products[i] = 0;
			for (int j = 1; j <= i / 2; j++) {
				max = products[j] * products[i - j];
				if (products[i] < max) {
					products[i] = max;
				}
			}

		}
		return products[n];

	}

	/**
	 * JZ14.2贪心法减绳子
	 * 
	 * @param n
	 * @return
	 */
	public int cuttingRopeByGreedy(int n) {
		if (n < 2) {
			return 0;
		}
		if (n == 2)
			return 1;
		if (n == 3) {
			return 2;
		}

		int timesOf3 = n / 3;
		// 注意：余数为1，即剪完最后一段长度为3的绳子，会剩下一段长度为1的绳子，此时不应该采取此减法
		// 应当将最后一段长度为4的绳子减为2+2
		if (n - timesOf3 * 3 == 1) {
			timesOf3 = timesOf3 - 1;
		}

		// n - timesOf3*3 = 0，2，4
		int timesOf2 = (n - timesOf3 * 3) / 2;
		return (int) Math.pow(3, timesOf3) * (int) Math.pow(2, timesOf2);
	}

	/**
	 * JZ14.3贪心法减绳子
	 * 
	 * @param n
	 * @return
	 */
	public int cuttingRopeByGreedyForBigData(int n) {

		double res = 0;
		if (n <= 1)
			return 0;
		if (n == 2) {
			return 1;
		}
		if (n == 3) {
			return 2;
		}

		int timeOf3 = n / 3;
		if (n - timeOf3 * 3 == 1) {
			timeOf3 = timeOf3 - 1;
		}
		int timeOf2 = (n - timeOf3 * 3) / 2;

		double resOf3 = 1;
		for (int i = 0; i < timeOf3; i++) {
			resOf3 = (resOf3 * 3) % (1e9 + 7);
		}
		double resOf2 = 1;
		for (int j = 0; j < timeOf2; j++) {
			resOf2 = (resOf2 * 2) % (1e9 + 7);
		}
		// res = resOf2 % (1e9+7) * (resOf3 % (1e9+7));
		// res %= (1e9+7);
		res = (resOf3 * resOf2) % (1e9 + 7);
		return (int) res;

	}

	/**
	 * JZ15.1 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2
	 * 位是 1。因此，如果输入 9，则该函数输出 2。
	 * 
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 * 
	 * 与运算解法 注:将一个整数减1并与原整数作与运算，原整数最右边的1会变成0
	 * 
	 * @param n
	 * @return
	 */
	public int hammingWeightByAnd(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = (n - 1) & n;
		}
		return count;
	}

	/**
	 * JZ15.2移位运算
	 * 
	 * @param n
	 * @return
	 */
	public int hammingWeightByMoving(int n) {
		int count = 0;
		// 不移动输入的数字n，而是将数字1进行向右移位操作
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) == 1) {
				count++;
			}
			flag = flag << 1;
		}
		return count;
	}

	public static boolean GLOBAL_INVALIDINPUT = false;

	/**
	 * x: 基数 n: 指数
	 */
	public static double myPow(double x, int n) {

		if (x == 0 && n <= 0) {
			GLOBAL_INVALIDINPUT = true;
			return 0.0;
		}

		// x是否是负数
		// n是否是负数
		boolean isLessZero = false;
		long temp = (long) n;
		if (temp < 0) {
			temp = -temp;
			isLessZero = true;
		}
		double res = 1;
		double base = x;
		while (temp > 0) {
			// double res = pows(base, n >> 1);
			if ((temp & 0x1) == 1) {
				res *= base;
			}
			base *= base;
			temp = temp >> 1;
		}
		// double res = pows(x, temp);
		if (isLessZero) {
			res = 1 / res;
		}

		return res;

	}

	public double pows(double base, long n) {

		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return base;
		}

		double res = pows(base, n >> 1);
		res *= res;
		if ((n & 0x1) == 1) {
			res *= base;
		}

		return res;
	}

	/**
	 * 前序遍历
	 * 
	 * @param root
	 */
	public static void preOrderTree(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode p = root;
		while (p != null || stack.size() > 0) {

			if (p != null) {
				// 入栈
				stack.offerFirst(p);
				System.out.println(p.val);
				p = p.left;
			} else {
				// 出栈
				p = stack.pollFirst();
				// System.out.println(p);
				p = p.right;
			}
		}
	}

	/**
	 * 并查集
	 * @author Lenovo
	 *
	 */
	private class UnionFind {

		private int[] parent;

		public UnionFind(int n) {
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
			}
		}

		/**
		 * 寻找x的根节点
		 * 
		 * @param x
		 * @return
		 */
		public int findRoot(int x) {
			while (x != parent[x]) {
				parent[x] = parent[parent[x]];
				x = parent[x];
			}
			return x;
		}

		/**
		 * @param x
		 * @param y
		 * @return 如果合并成功，返回 true
		 */
		public void union(int x, int y) {
			int rootX = findRoot(x);
			int rootY = findRoot(y);
			parent[rootX] = rootY;
		}

		public boolean isConnected(int x, int y) {
			return findRoot(x) == findRoot(y);
		}
	}

	public static String solve(String str) {
		// write code here
		char[] res = str.toCharArray();
		int left = 0, right = str.length() - 1;
		while (left < right) {
			char tmp = res[left];
			res[left] = res[right];
			res[right] = tmp;
			left++;
			right--;
		}
		return String.valueOf(res);
	}

	public static boolean judge(String str) {
		// write code here
		boolean isSymmetric = false;
		int left = 0, right = str.length() - 1;
		while (left < right) {
			if (str.charAt(left) == str.charAt(right)) {
				left++;
				right--;
			} else {
				break;
			}

		}
		if (left == right || right == left - 1) {
			isSymmetric = true;
		}

		return isSymmetric;
	}

	public static int[] ans = new int[8];

	public static int splitN(int num, int step) {
		int res = 0;

		for (int i = 1; i <= num; i++) {
			if (step >= 2 && i < ans[step - 1]) {
				continue;
			}
			ans[step] = i;
			splitN(num - i, ++step);
		}

		return res;
	}

	/**
	 * 快取幂
	 * @param a
	 * @param exp
	 */
	@Test
	public void testGetPow(){
		
		System.out.println(myPow(2, 3));
		//a不考虑负数
		//exp指数也不考虑负数
		int base = 2;
		int res = 1;
		int tempExp = 10;
		while(tempExp > 0){
			if((tempExp & 1) == 1){
				//奇数次
				res *= base;
			}
			base *= base;
			tempExp >>= 1 ;
		}
		System.out.println("test==>"+res);
	}
	
	
	
	public void testReBuildTree(int[] preOrder, int[] inOrder, int preLeft, int preRight, int inLeft, int inRight){
		
	}
	
	

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode father;

	TreeNode(int x) {
		val = x;
	}
}
