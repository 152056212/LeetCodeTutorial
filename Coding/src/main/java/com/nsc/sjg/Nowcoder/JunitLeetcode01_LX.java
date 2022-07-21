package com.nsc.sjg;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class JunitLeetcode01_LX {

	/**
	 * <p>
	 * LK2. 两数相加 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
	 * 
	 * <p>
	 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
	 * 
	 * <p>
	 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
	 * <p>
	 * 输入：l1 = [2,4,3], l2 = [5,6,4] 输出：[7,0,8] 解释：342 + 465 = 807.
	 * <p>
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/add-two-numbers
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	// @Test
	public void test2NumsAddedByListNode() {

		ListNode num10 = new ListNode(3);
		ListNode num11 = new ListNode(9);
		ListNode num12 = new ListNode(9);
		ListNode num13 = new ListNode(9);
		ListNode num14 = new ListNode(9);
		ListNode num15 = new ListNode(9);
		ListNode num16 = new ListNode(9);
		ListNode num17 = new ListNode(9);
		num10.next = num11;
		num11.next = num12;
		num12.next = num13;
		num13.next = num14;
		num14.next = num15;
		num15.next = num16;
		num16.next = num17;
		ListNode num20 = new ListNode(9);
		ListNode num21 = new ListNode(2);
		ListNode num22 = new ListNode(9);
		ListNode num23 = new ListNode(9);
		num20.next = num21;
		num21.next = num22;
		num22.next = num23;
		num21.next = num22;

		int tmpLow = 0;
		int tmpHigh = 0;
		int sum = 0;
		ListNode res = new ListNode(0);
		ListNode resTmp = res;
		ListNode num1Tmp = num10;
		ListNode num2Tmp = num20;

		while (num1Tmp != null && num2Tmp != null) {
			sum = num1Tmp.val + num2Tmp.val + tmpHigh;
			tmpLow = sum % 10;
			resTmp.next = new ListNode(tmpLow);
			resTmp = resTmp.next;
			tmpHigh = (sum >= 10) ? 1 : 0;
			num1Tmp = num1Tmp.next;
			num2Tmp = num2Tmp.next;
		}
		ListNode tmpNode = (num1Tmp != null) ? num1Tmp : num2Tmp;
		resTmp.next = tmpNode;
		while (true) {
			if (tmpNode != null) {
				if (tmpHigh == 0) {
					break;
				} else {
					// 当前节点数值大于10
					if (tmpHigh >= 1 && tmpNode.next == null) {
						sum = (tmpNode.val + tmpHigh);
						tmpNode.val = sum % 10;
						// 添加新的尾节点
						if (sum >= 10) {
							tmpNode.next = new ListNode(1);
						}
						break;
					} else {
						if (tmpHigh >= 1 && tmpNode.next != null) {
							sum = (tmpNode.val + tmpHigh);
							tmpNode.val = sum % 10;
							tmpHigh = (sum >= 10) ? 1 : 0;
							tmpNode = tmpNode.next;
						} else {
							break;
						}
					}
				}
			} else {
				if (tmpHigh > 0) {
					tmpNode = new ListNode(1);
					resTmp.next = tmpNode;
				}
				break;
			}
		}
		System.out.println(res.val);

	}

	/**
	 * <p>
	 * LK3.给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 示例 1:
	 * 
	 * <p>
	 * 输入: s = "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
	 * 
	 * <p>
	 * 示例 2:
	 * 
	 * <p>
	 * 输入: s = "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
	 * 
	 * <p>
	 * 示例 3:
	 * 
	 * <p>
	 * 输入: s = "pwwkew" 输出: 3 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。 请注意，你的答案必须是 子串
	 * 的长度，"pwke" 是一个子序列，不是子串。
	 * 
	 * <p>
	 * 示例 4:
	 * 
	 * <p>
	 * 输入: s = "" 输出: 0
	 * 
	 * 
	 * 
	 * <p>
	 * 提示：
	 * 
	 * <p>
	 * 0 <= s.length <= 5 * 104 s 由英文字母、数字、符号和空格组成
	 * 
	 * <p>
	 * 来源：力扣（LeetCode）
	 * <p>
	 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
	 * <p>
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	// @Test
	public void testOldestStringWithNoRepeating() {
		String s = " ";
		int len = s.length();
		int max = len > 0 ? 1 : 0;
		int dpPre = 1;
		int dpCur = 1;
		for (int i = 1; i < len; i++) {
			int j = i - 1;
			for (; j >= (i - dpPre); j--) {
				if (s.charAt(j) == s.charAt(i)) {
					dpCur = i - j;
					break;
				}
			}
			if (j < i - dpPre) {
				dpCur = dpPre + 1;
			}
			dpPre = dpCur;
			max = Math.max(max, dpCur);
		}
		System.out.println(max);
	}

	/**
	 * <p>
	 * JK4.给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
	 * 
	 * 
	 * 
	 * <p>
	 * 示例 1：
	 * 
	 * <p>
	 * 输入：nums1 = [1,3], nums2 = [2] 输出：2.00000 解释：合并数组 = [1,2,3] ，中位数 2
	 * 
	 * <p>
	 * 示例 2：
	 * 
	 * <p>
	 * 输入：nums1 = [1,2], nums2 = [3,4] 输出：2.50000 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) /
	 * 2 = 2.5
	 * 
	 * <p>
	 * 示例 3：
	 * 
	 * <p>
	 * 输入：nums1 = [0,0], nums2 = [0,0] 输出：0.00000
	 * 
	 * <p>
	 * 示例 4：
	 * 
	 * <p>
	 * 输入：nums1 = [], nums2 = [1] 输出：1.00000
	 * 
	 * <p>
	 * 示例 5：
	 * 
	 * <p>
	 * 输入：nums1 = [2], nums2 = [] 输出：2.00000
	 * 
	 * <p>
	 * 来源：力扣（LeetCode）
	 * <p>
	 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
	 * <p>
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	// @Test
	public void testTheMedian() {
		int[] nums1 = new int[] { 1, 3 };
		int[] nums2 = new int[] { 2, 7 };
		int[] numsRes = new int[nums1.length + nums2.length];

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		if (nums1.length == 0 && nums2.length > 0) {
			min = nums2[0];
		}
		if (nums1.length > 0 && nums2.length == 0) {
			min = nums1[0];
		}

		// 归并过程中寻找最小数和最大数
		// 左路指针
		int i = 0;
		// 右路指针
		int j = 0;
		int k = 0;
		for (; i < nums1.length && j < nums2.length;) {
			if (nums1[i] <= nums2[j]) {
				// 左路小于右路
				min = Math.min(min, nums1[i++]);
				max = Math.max(max, nums2[j]);
			} else {
				// 左路大于右路
				min = Math.min(min, nums2[j++]);
				max = Math.max(max, nums1[i]);
			}
		}
		while (i < nums1.length) {
			max = Math.max(max, nums1[i++]);
		}
		while (j < nums2.length) {
			max = Math.max(max, nums2[j++]);
		}
		System.out.println(min + " " + max + " " + (min + max) / 2.0);
		System.out.println();
	}

	private void testMergeSorting(int[] arr, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		testMergeSorting(arr, low, mid);
		testMergeSorting(arr, mid + 1, high);
		testMerge(arr, low, high, mid);
	}

	private void testMerge(int[] arr, int low, int high, int mid) {
		int i = low;
		int j = mid + 1;
		int[] tmp = new int[high - low + 1];
		int idx = 0;
		for (; i <= mid && j <= high; idx++) {
			if (arr[i] <= arr[j]) {
				tmp[idx] = arr[i++];
			} else {
				tmp[idx] = arr[j++];
			}
		}
		while (i <= mid) {
			tmp[idx++] = arr[i++];
		}
		while (j <= high) {
			tmp[idx++] = arr[j++];
		}
		for (int k = 0; k < tmp.length; k++) {
			arr[low + k] = tmp[k];
		}
	}

	/**
	 * JK5.给你一个字符串 s，找到 s 中最长的回文子串。
	 */
	// @Test
	public void testLSS() {
		String s = "abbcb";
		int len = s.length();
		if (len < 2) {
			System.out.println(s);
			return;
		}
		int[][] dp = new int[len][len];
		StringBuilder res = new StringBuilder(len);
		int startId = 0;
		int maxLen = 1;
		for (int i = 0; i < len - 1; i++) {
			dp[i][i] = 1;
			if (s.charAt(i) == s.charAt(i + 1)) {
				dp[i][i + 1] = 1;
				startId = i;
				maxLen = 2;
			}
		}

		for (int L = 3; L <= len; L++) {
			for (int i = 0; i < len - L + 1; i++) {
				int j = i + L - 1;
				if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == 1) {
					dp[i][j] = 1;
					startId = i;
					maxLen = L;
				}
			}
		}
		for (int i = 0; i < maxLen; i++) {
			res.append(s.charAt(i + startId));
		}
		System.out.println(res);

	}

	// @Test
	public void testReversInteger() {
		System.out.println(reversInteger());
	}

	public int reversInteger() {
		int x = 1534236469;

		try {
			int res = 0;
			int tmp = 0;
			while (x != 0) {
				tmp = x % 10;
				if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
					return 0;
				}
				res = res * 10 + tmp;
				x /= 10;
			}
			return res;
			// if(x < 0) {
			// StringBuilder sb = new StringBuilder(""+(-x));
			// return -1*Integer.valueOf(sb.reverse().toString());
			// }else {
			// StringBuilder sb = new StringBuilder(""+x);
			// return Integer.valueOf(sb.reverse().toString());
			// }
		} catch (Exception e) {
			return 0;
		}

	}

	/**
	 * 转罗马数字
	 */
	// @Test
	public void testRomanNumber() {
		int num = 1994;
		// StringBuilder res = new StringBuilder();
		String res = "";
		int tmp = 0;
		int count = 0;
		while (num != 0) {
			tmp = (num % 10) * (int) Math.pow(10, count++);
			if (tmp < 10 && tmp > 0) {
				// 个位数
				if (tmp == 4) {
					res = "IV" + res;
				} else if (tmp == 9) {
					res = "Ix" + res;
				} else if (tmp == 5) {
					res = "V" + res;
				} else if (tmp < 5) {
					for (int i = 0; i < tmp; i++) {
						res = "I" + res;
					}
				} else {
					String str = "V";
					for (int i = 0; i < tmp - 5; i++) {
						str += "I";
					}
					res = str + res;
				}
			} else {
				if (tmp < 100) {
					// 十位数
					if (tmp == 40) {
						res = "XL" + res;
					} else if (tmp == 90) {
						res = "XC" + res;
					} else if (tmp == 50) {
						res = "L" + res;
					} else if (tmp < 50) {
						for (int i = 0; i < tmp / 10; i++) {
							res = "X" + res;
						}
					} else {
						String str = "L";
						for (int i = 0; i < (tmp - 50) / 10; i++) {
							str += "X";
						}
						res = str + res;
					}
				} else {
					if (tmp < 1000) {
						// 百位数
						if (tmp == 400) {
							res = "CD" + res;
						} else if (tmp == 900) {
							res = "CM" + res;
						} else if (tmp == 500) {
							res = "D" + res;
						} else if (tmp < 500) {
							for (int i = 0; i < tmp / 100; i++) {
								res = "C" + res;
							}
						} else {
							String str = "D";
							for (int i = 0; i < (tmp - 500) / 100; i++) {
								str += "C";
							}
							res = str + res;
						}
					} else {
						// 千位数
						for (int i = 0; i < tmp / 1000; i++) {
							res = "M" + res;
						}
					}
				}
			}
			num /= 10;
		}
		System.out.println(res);
	}

	/**
	 * LK.14.最长公共前缀
	 */
	// @Test
	public void testLCPre() {
		String[] strs = new String[2];
		strs[0] = "aa";
		strs[1] = "bb";
		if (strs == null || strs.length == 0) {
			return;
		}
		// if(strs.length == 1) {
		// return strs[0];
		// }

		int count = 0;
		String str1 = strs[count];
		int len1 = str1.length();
		if (len1 == 0) {
			return;
		}
		StringBuilder sb = new StringBuilder(str1.length());
		boolean flag = true;
		while (flag) {
			for (int i = 1; i < strs.length; i++) {
				if (strs[i].length() > count && str1.length() > count) {
					if (str1.charAt(count) != strs[i].charAt(count)) {
						flag = false;
						break;
					}
				} else {
					flag = false;
				}

			}
			if (flag == true) {
				sb.append(str1.charAt(count));
				count++;
			}
		}
		System.out.println(sb.toString());
	}

	/**
	 * <p>
	 * LK15.给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为
	 * 0 且不重复的三元组。
	 * <p>
	 * 注意：答案中不可以包含重复的三元组。
	 * 
	 * 
	 * <p>
	 * 示例 1：
	 * <p>
	 * 输入：nums = [-1,0,1,2,-1,-4] 输出：[[-1,-1,2],[-1,0,1]]
	 * <p>
	 * 示例 2：
	 * <p>
	 * 输入：nums = [] 输出：[]
	 * <p>
	 * 示例 3：
	 * <p>
	 * 输入：nums = [0] 输出：[]
	 * <p>
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	// @Test
	public void testTheSumOfThreeNumber() {
		int[] nums = new int[] { -1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4 };

		List<List<Integer>> res = new ArrayList<>(3);
		if (nums == null || nums.length < 3) {
			// return res;
		}
		Arrays.sort(nums);
		int low = 0;
		int high = nums.length - 1;
		for (int i = 0; i < nums.length - 2; i++) {
			low = i + 1;
			high = nums.length - 1;
			while (low < high && nums[i] <= 0 && nums[high] >= 0) {
				if (nums[i] + nums[low] + nums[high] == 0) {
					List<Integer> tmpList = new ArrayList<Integer>();
					tmpList.add(nums[i]);
					tmpList.add(nums[low]);
					tmpList.add(nums[high]);
					res.add(tmpList);
					while (low + 1 < high && nums[low] == nums[low + 1]) {
						low++;
					}
					while (high > low + 1 && nums[high - 1] == nums[high]) {
						high--;
					}
					low++;
				} else {
					// 移动
					if (nums[i] + nums[low] + nums[high] < 0) {
						low++;
					} else {
						high--;
					}
				}

			}
			while (i < nums.length - 2 && nums[i] == nums[i + 1]) {
				i++;
			}
		}

		System.out.println(res);
	}

	/**
	 * <p>
	 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target
	 * 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
	 * 
	 * 
	 * <p>
	 * 示例：
	 * <p>
	 * 输入：nums = [-1,2,1,-4], target = 1 输出：2 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2)
	 * 。
	 * <p>
	 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/3sum-closest
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	// @Test
	public void testLatestNum() {
		int target = 3;
		int[] nums = new int[] { -1, 0, 1, 1, 55 };
		if (nums == null || nums.length < 3) {
			return;
		}
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int resPre = 0, resCur = 0;
		int low = 0;
		int high = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			low = i + 1;
			high = nums.length - 1;
			while (low < high) {
				resCur = nums[i] + nums[low] + nums[high];
				int sub = Math.abs(target - resCur);
				System.out.println(i + " " + low + " " + high + " " + resCur + " " + min);
				if (min > sub) {
					min = sub;
					resPre = resCur;
				}
				if (min == 0) {
					i = nums.length;
					break;
				}
				// 不能跳跃，此处不再有等式的传递性
				// while(low+1 < high && nums[low+1] == nums[low]) {
				// low++;
				// }
				// while(high > low+1 && nums[high-1] == nums[high]) {
				// high--;
				// }
				if (resCur < target) {
					low++;
				} else {
					high--;
				}

			}
			while (i < nums.length - 2 && nums[i + 1] == nums[i]) {
				i++;
			}
		}
		System.out.println(min + " res==>" + resPre);
	}

	/**
	 * <p>
	 * LC17.给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
	 * <p>
	 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 提示：
	 * <p>
	 * 0 <= digits.length <= 4
	 * <p>
	 * digits[i] 是范围 ['2', '9'] 的一个数字。
	 * 
	 * <p>
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	//@Test
	public void testCombinationOfPhoneNum() {
		String digits = "27";
		List<String> res = new LinkedList<>();
		if (digits == null && digits.length() == 0) {
			return;
		}
		char[] chrs = digits.toCharArray();
		Map<Character, String> map = new HashMap<>();
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		StringBuilder sb = new StringBuilder(chrs.length);
		for (int i = 0; i < chrs.length; i++) {
			sb.append(map.get(chrs[i]).charAt(0));
		}
		getCombPN(chrs, 0, map, sb, res);
		System.out.println(res.size());
		System.out.println(res);

	}

	private void getCombPN(char[] chrs, int cur, Map<Character, String> map, StringBuilder sb, List<String> resList) {
		if (cur > chrs.length - 1) {
			return;
		}
		String tmp = map.get(chrs[cur]);
		for (int i = 0, len = tmp.length(); i < len; i++) {
			sb.setCharAt(cur, tmp.charAt(i));
			// for(int j = cur+1; j < chrs.length; j++) {
			getCombPN(chrs, cur + 1, map, sb, resList);
			// }
			if (cur == chrs.length - 1) {
				resList.add(sb.toString());
			}
		}

	}

	@Test
	public void testRemoveNthFromEnd() {
		ListNode head = new ListNode(1);
//		head.next = new ListNode(2);
//		head.next.next = new ListNode(3);
//		head.next.next.next = new ListNode(4);
//		head.next.next.next.next = new ListNode(5);
		removeNthFromEnd(head,1);
	}

	/**
	 * <p>
	 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
	 * <p>
	 * 进阶：你能尝试使用一趟扫描实现吗？
	 * 
	 * @param head
	 * @param n
	 * @return
	 */
	private ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null) {
			return null;
		}
		if(head.next == null && n == 1) {
			return head;
		}
		ListNode tmpHead = head;
		ListNode low = head,high;
		ListNode tmp = head;
		int tmpId = 1;
		
		while(tmpId != n && tmp.next != null) {
			tmp = tmp.next;
			tmpId++;
		}
		high = tmp;
		while(high.next != null){
			tmp = low;
			low = low.next;
			high = high.next;
		}
		//System.out.println(tmp.val+" "+ low.val+ " "+ high.val);
		tmp.next = low.next;
		return head;
	}

	@Test
	public void testDivisor(){
		int dividend = 2; 
		int divisor = 1;
		if(divisor == 0 || dividend == 0){
			return ;
		}
		if(dividend < divisor){
			//return 00;
		}
		if(dividend == divisor){
			//return 1;
		}
		int modNum = dividend - divisor;
		int res = 0;
		while(modNum > 0){
			modNum = modNum - divisor;
			res++;
		}
		
	}
}
