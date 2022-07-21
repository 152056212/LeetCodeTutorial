/**
 * 
 */
package com.nsc.sjg;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Lenovo
 *
 */
public class JUnit0401_HW {

	public static Scanner scan = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		scan = new Scanner(System.in);
	}

	/**
	 * <p>
	 * 写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
	 */
	// @Test
	public void testGetApproxValue() {
		// fail("Not yet implemented");
		BigDecimal value = new BigDecimal(scan.nextLine());
		int res = 0;
		res = value.setScale(0, BigDecimal.ROUND_HALF_UP).intValue();
		System.out.println(res);
	}

	/**
	 * <p>
	 * 题目描述
	 * <p>
	 * 数据表记录包含表索引和数值（int范围的正整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。
	 * 
	 * <p>
	 * 输入描述: 先输入键值对的个数 然后输入成对的index和value值，以空格隔开
	 * 
	 * <p>
	 * 输出描述: 输出合并后的键值对（多行）
	 */
	// @Test
	public void testUnionList() {
		// 键值对个数
		int count = scan.nextInt();
		int curCount = 0;
		TreeMap<Integer, Integer> map = new TreeMap<>();
		int idx = 0;
		int value = 0;
		while (scan.hasNext()) {

			idx = scan.nextInt();
			value = scan.nextInt();
			Integer mapValue = map.get(idx);
			if (mapValue != null) {
				value += mapValue;
			}
			map.put(idx, value);
			if (++curCount == count) {
				break;
			}
		}
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry entry = (Map.Entry) iter.next();
			Integer k = (Integer) entry.getKey();
			Integer v = (Integer) entry.getValue();
			System.out.println(k + " " + v);
		}
	}

	/**
	 * <p>
	 * 题目描述
	 * <p>
	 * 编写一个函数，计算字符串中含有的不同字符的个数。字符在ACSII码范围内(0~127)，换行表示结束符，不算在字符里。不在范围内的不作统计。
	 * 多个相同的字符只计算一次 例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。 输入描述: 输入一行没有空格的字符串。
	 * 
	 * <p>
	 * 输出描述: 输出范围在(0~127)字符的个数。
	 * 
	 * <p>
	 * 示例1 输入 复制 abc 输出 复制 3
	 */
	// @Test
	public void testACSIIOfInteger() {
		BitSet used = new BitSet(129);
		String str = scan.next();
		for (int i = 0, len = str.length(); i < len; i++) {
			char tmp = str.charAt(i);
			if (tmp >= 0 && tmp <= 127 && used.get(tmp) == false) {
				used.set(tmp);
			}
		}
		int res = 0;
		for (int i = 0; i < 128; i++) {
			if (used.get(i) == true) {
				res++;
			}
		}
		System.out.println(res);
	}

	/**
	 * <p>
	 * 题目描述 将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
	 * 所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
	 * 
	 * <p>
	 * 输入描述: 输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
	 * 
	 * <p>
	 * 输出描述: 得到逆序的句子
	 * 
	 * <p>
	 * 示例1 输入 复制 I am a boy 输出 复制 boy a am I
	 */
	// @Test
	public void testReverseSentence() {
		String str = "";
		while (scan.hasNext()) {
			str += scan.next();
		}
		System.out.println(str);
		String[] strUnit = str.split(" ");
		StringBuilder sb = new StringBuilder(strUnit.length * 2 - 1);
		for (int i = strUnit.length - 1; i >= 0; i--) {
			if (i == 0) {
				sb.append(strUnit[i]);
			} else {
				sb.append(strUnit[i] + " ");
			}

		}
		System.out.println(sb);
	}

	/**
	 * <p>
	 * 题目描述 给定n个字符串，请对n个字符串按照字典序排列。 输入描述:
	 * <p>
	 * 输入第一行为一个正整数n(1≤n≤1000),下面n行为n个字符串(字符串长度≤100),字符串中只含有大小写字母。 输出描述:
	 * <p>
	 * 数据输出n行，输出结果为按照字典序排列的字符串。 示例1 输入 复制 9 cap to cat card two too up boat boot
	 * <p>
	 * 输出 复制 boat boot cap card cat to too two up
	 */
	// @Test
	public void testLexOrder() {
		int size = scan.nextInt();
		String[] arr = new String[size];

		int k = 0;
		while (k < size) {
			arr[k++] = scan.next().trim();
		}
		Arrays.sort(arr);
		for (int i = 0; i < size; i++) {
			System.out.println(arr[i]);
		}
	}

	// @Test
	public void testQuickSort() {
		int[] arr = new int[] { 1, 3, 2, 4 };
		qus(arr, 0, arr.length - 1);
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void qus(int[] arr, int low, int high) {
		if (arr == null || low >= high || high > arr.length) {
			return;
		}
		int left = low - 1, right = high + 1;
		int mid = 0;
		while (true) {
			mid = (left + right) / 2;
			while (arr[++left] < arr[mid])
				;
			while (arr[--right] > arr[mid])
				;
			if (left >= right) {
				break;
			}
			int tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;

		}
		qus(arr, low, left - 1);
		qus(arr, right + 1, high);
	}

	/**
	 * <p>
	 * 题目描述 王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，
	 * 下表就是一些主件与附件的例子： 主件 附件 电脑 打印机，扫描仪 书柜 图书 书桌 台灯，文具 工作椅 无
	 * 如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2
	 * 个附件。附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：用整数 1 ~ 5 表示，第
	 * 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。他希望在不超过 N 元（可以等于 N
	 * 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。 设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k
	 * 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为： v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ …
	 * +v[j k ]*w[j k ] 。（其中 * 为乘号） 请你帮助王强设计一个满足要求的购物单。
	 * 
	 * 
	 * 
	 * 
	 * <p>
	 * 输入描述: 输入的第 1 行，为两个正整数，用一个空格隔开：N m
	 * 
	 * （其中 N （ <32000 ）表示总钱数， m （ <60 ）为希望购买物品的个数。）
	 * 
	 * 
	 * <p>
	 * 从第 2 行到第 m+1 行，第 j 行给出了编号为 j-1 的物品的基本数据，每行有 3 个非负整数 v p q
	 * 
	 * 
	 * <p>
	 * （其中 v 表示该物品的价格（ v<10000 ）， p 表示该物品的重要度（ 1 ~ 5 ）， q 表示该物品是主件还是附件。如果 q=0
	 * ，表示该物品为主件，如果 q>0 ，表示该物品为附件， q 是所属主件的编号）
	 * 
	 * 
	 * 
	 * 
	 * <p>
	 * 输出描述: 输出文件只有一个正整数，为不超过总钱数的物品的价格与重要度乘积的总和的最大值（ <200000 ）。 示例1 输入 复制 1000 5
	 * 800 2 0 400 5 1 300 5 1 400 3 0 500 2 0 输出 复制 2200
	 */
	// @Test
	public static void testDPShopingList() {
		// 总钱数
		int total = scan.nextInt();
		// 希望购买的物品数量
		int itemNum = scan.nextInt();
		// 物品价格
		int[] prices = new int[itemNum];
		// 物品重要度
		int[] weights = new int[itemNum];
		// 物品编号
		int[] itemIds = new int[itemNum];
		// 主件编号
		BitSet supersSet = new BitSet(itemNum);
		int curIdx = 0;
		// 初始化
		while (scan.hasNext()) {
			prices[curIdx] = scan.nextInt();
			weights[curIdx] = scan.nextInt();
			itemIds[curIdx] = scan.nextInt();
			if (itemIds[curIdx] == 0) {
				supersSet.set(curIdx);
			}
			curIdx++;
			if (curIdx == itemNum) {
				break;
			}
		}
		// 背包问题计算
		for (int i = 0; i < itemNum; i++) {
			// for(int j = 0; j < ){
			//
			// }

		}

	}

	/**
	 * <p>
	 * 题目描述 开发一个坐标计算工具，
	 * A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，
	 * 并将最终输入结果输出到输出文件里面。
	 * 
	 * <p>
	 * 输入：
	 * 
	 * <p>
	 * 合法坐标为A(或者D或者W或者S) + 数字（两位以内）
	 * 
	 * <p>
	 * 坐标之间以;分隔。
	 * 
	 * <p>
	 * 非法坐标点需要进行丢弃。如AA10; A1A; $%$; YAD; 等。
	 * 
	 * <p>
	 * 下面是一个简单的例子 如：
	 * 
	 * <p>
	 * A10;S20;W10;D30;X;A1A;B10A11;;A10;
	 * 
	 * <p>
	 * 处理过程：
	 * 
	 * <p>
	 * 起点（0,0）
	 * 
	 * + A10 = （-10,0）
	 * 
	 * + S20 = (-10,-20)
	 * 
	 * + W10 = (-10,-10)
	 * 
	 * + D30 = (20,-10)
	 * 
	 * + x = 无效
	 * 
	 * + A1A = 无效
	 * 
	 * + B10A11 = 无效
	 * 
	 * + 一个空 不影响
	 * 
	 * + A10 = (10,-10)
	 * 
	 * <p>
	 * 结果 （10， -10）
	 * 
	 * <p>
	 * 注意请处理多组输入输出
	 * 
	 * <p>
	 * 输入描述: 一行字符串
	 * 
	 * <p>
	 * 输出描述: 最终坐标，以逗号分隔
	 * 
	 * <p>
	 * 示例1 输入 复制 A10;S20;W10;D30;X;A1A;B10A11;;A10; 输出 复制 10,-10
	 */
	// @Test
	public void testXYMoving() {
		String str = scan.nextLine();
		String[] moving = str.split(";");
		int x = 0, y = 0;
		int res = 0;
		for (int i = 0; i < moving.length; i++) {
			if (moving[i].length() > 0) {
				switch (moving[i].charAt(0)) {
				case 'A':
					res = getMovingNum(moving[i].substring(1));
					if (res != -1) {
						x -= res;
					}
					break;
				case 'D':
					res = getMovingNum(moving[i].substring(1));
					if (res != -1) {
						x += res;
					}
					break;
				case 'W':
					res = getMovingNum(moving[i].substring(1));
					if (res != -1) {
						y += res;
					}
					break;
				case 'S':
					res = getMovingNum(moving[i].substring(1));
					if (res != -1) {
						y -= res;
					}
					break;
				default:
					break;
				}
			}
		}
		System.out.println(x + "," + y);

	}

	/**
	 * 
	 * @param str
	 *            移动步数(字符串格式)
	 * @return
	 */
	private static int getMovingNum(String str) {
		int res = -1;
		try {
			res = Integer.parseInt(str);
		} catch (Exception e) {
			return -1;
		}
		return res;
	}

	/**
	 * <p>
	 * 题目描述 密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
	 * 
	 * 
	 * 
	 * <p>
	 * 假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，
	 * 这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
	 * 
	 * 
	 * 
	 * <p>
	 * 他是这么变换的，大家都知道手机上的字母： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6,
	 * pqrs--7, tuv--8 wxyz--9, 0--0,就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
	 * 
	 * 
	 * 
	 * <p>
	 * 声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，
	 * z往后移是a哦。
	 * 
	 * 
	 * <p>
	 * 输入描述: 输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
	 * 
	 * <p>
	 * 输出描述: 输出渊子真正的密文
	 * 
	 * <p>
	 * 示例1 输入 复制 YUANzhi1987 输出 复制 zvbo9441987
	 */
	// @Test
	public void testSimplePassword() {
		// 大写字母转小写
		char A = 'A';
		char a = 'a';
		String str = scan.nextLine();
		int len = str.length();
		StringBuilder stringBuilder = new StringBuilder(str.length());
		for (int i = 0; i < len; i++) {
			char tmp = str.charAt(i);
			if (tmp >= 'A' && tmp <= 'Z') {
				// 转大小写
				char chr = (char) (a + (str.charAt(i) - A));
				stringBuilder.append(chr == 'z' ? 'a' : (char) (chr + 1));
			} else {
				if (tmp >= 'a' && tmp <= 'c') {
					stringBuilder.append(2);
				} else if (tmp >= 'd' && tmp <= 'f') {
					stringBuilder.append(3);
				} else if (tmp >= 'g' && tmp <= 'i') {
					stringBuilder.append(4);
				} else if (tmp >= 'j' && tmp <= 'l') {
					stringBuilder.append(5);
				} else if (tmp >= 'm' && tmp <= 'n') {
					stringBuilder.append(6);
				} else if (tmp >= 'p' && tmp <= 's') {
					stringBuilder.append(7);
				} else if (tmp >= 't' && tmp <= 'v') {
					stringBuilder.append(8);
				} else if (tmp >= 'w' && tmp <= 'z') {
					stringBuilder.append(9);
				} else
					stringBuilder.append(tmp);
			}
		}
		System.out.println(stringBuilder.toString());
	}

	/**
	 * <p>
	 * 题目描述 实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
	 * <p>
	 * 注意每个输入文件有多组输入，即多个字符串用回车隔开 输入描述: 字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
	 * 
	 * <p>
	 * 输出描述: 删除字符串中出现次数最少的字符后的字符串。
	 * 
	 * <p>
	 * 示例1 输入 复制 abcdd aabcddd 输出 复制 dd aaddd
	 */
	// @Test
	public void testDelMinChar() {
		while (scan.hasNext()) {
			String str = scan.nextLine();
			System.out.println(getDeledString(str));
		}

	}

	private static String getDeledString(String str) {
		if (str == null || str.length() == 0) {
			return "";
		} else {
			Map<Character, Integer> map = new HashMap<Character, Integer>();
			// 统计出现次数
			int len = str.length();
			StringBuilder res = new StringBuilder(len);

			for (int i = 0; i < len; i++) {
				char tmp = str.charAt(i);
				if (map.get(tmp) == null) {
					map.put(str.charAt(i), 1);
				} else {
					int count = map.get(tmp);
					map.put(tmp, ++count);

				}
			}

			int min = Integer.MAX_VALUE;
			for (int times : map.values()) {
				min = Math.min(min, times);
			}

			for (int i = 0; i < len; i++) {
				char tmp = str.charAt(i);
				if (min != (int) map.get(tmp)) {
					res.append(tmp);
				}
			}
			return res.toString().trim();
		}
	}

	/**
	 * <p>
	 * 题目描述 计算最少出列多少位同学，使得剩下的同学排成合唱队形
	 * 
	 * <p>
	 * 说明：
	 * 
	 * <p>
	 * N位同学站成一排，音乐老师要请其中的(N-K)位同学出列，使得剩下的K位同学排成合唱队形。
	 * 合唱队形是指这样的一种队形：设K位同学从左到右依次编号为1，2…，K，他们的身高分别为T1，T2，…，TK，
	 * 则他们的身高满足存在i（1<=i<=K）使得T1<T2<......<Ti-1<Ti>Ti+1>......>TK。
	 * 
	 * <p>
	 * 你的任务是，已知所有N位同学的身高，计算最少需要几位同学出列，可以使得剩下的同学排成合唱队形。
	 * 
	 * 
	 * <p>
	 * 注意不允许改变队列元素的先后顺序 请注意处理多组输入输出！
	 * 
	 * <p>
	 * 输入描述: 整数N
	 * 
	 * <p>
	 * 输出描述: 最少需要几位同学出列
	 * 
	 * <p>
	 * 示例1 输入 复制 8 186 186 150 200 160 130 197 200 输出 复制 4
	 */
	//@Test
	public void testChorus() {
		// int[] values = new int[]{200,197,130,160, 200, 150, 186};
		// int[] values = new int[]{186,186,120};
		// int res = getLIS(values);
		int k = 0;
		while (scan.hasNext()) {
			String strSize = scan.nextLine();
			int size = Integer.valueOf(strSize);
			int[] chorusQueue = new int[size];
			String tmp = scan.nextLine();
			String[] strs = tmp.split(" ");
			for (String ele : strs) {
				chorusQueue[k] = Integer.valueOf(ele);
				k++;
			}
			if (k == size) {
				int supLeftRes = getLIS(chorusQueue);
				// 数组反转
				int mid = size / 2;
				int[] supRight = new int[size];
				for (int m = size - 1, n = 0; m >= 0; m--, n++) {
					supRight[n] = chorusQueue[m];
				}

				int supRightRes = getLIS(supRight);
				if (supLeftRes == size || supRightRes == size) {
					// 严格递增或者递减序列直接结束本次循环
					System.out.println(0);
					k = 0;
					continue;
				}

				int minRes = Integer.MAX_VALUE;
				for (int i = 0; i < size; i++) {
					int[] left = new int[i - 0];
					for (int j = 0; j < i - 0; j++) {
						left[j] = chorusQueue[j];
					}
					int leftRes = getLIS(left);
					int[] right = new int[size - i - 1];

					for (int m = 0, j = size - 1; j >= i + 1; j--, m++) {
						right[m] = chorusQueue[j];
					}
					int rightRes = getLIS(right);
					int resTmp = (size - leftRes - rightRes);
					if (resTmp < minRes) {
						minRes = resTmp;
					}
				}
				System.out.println(minRes);
				k = 0;
			}
		}
		System.out.println();
	}

	private static int getLIS(int[] values) {
		// 获取最长递增子序列
		int[] dp = new int[values.length];
		// List<Integer> res = new ArrayList<>(values.length);
		for (int i = 0; i < values.length; i++) {
			// 初始化最长子序列长度为1
			dp[i] = 1;
		}
		int max = values.length == 0 ? 0 : 1;
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < i; j++) {
				if (values[i] > values[j] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					max = Math.max(max, dp[i]);
				}
			}
		}
		// System.out.println("max_len "+max);
		return max;
	}

	//@Test
	public void testStringSorting() {
		/// String str = scan.nextLine();
		// String str = scan.nextLine();
		// char[] test = new char[]{'B','y','?','e'};
		// mergeSorting(test, 0, test.length-1);
		// System.out.println();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String str = scan.nextLine();
			char[] chrs = str.toCharArray();
			List<Character> list = new ArrayList<>();
			for (char chr : chrs) {
				if (Character.isLetter(chr)) {
					list.add(chr);
				}
			}
			Collections.sort(list, new Comparator<Character>() {
				@Override
				public int compare(Character o1, Character o2) {
					// TODO Auto-generated method stub
					return Character.toLowerCase(o1) - Character.toLowerCase(o2);
				}
			});

			StringBuilder sb = new StringBuilder(str.length());
			int idx = 0;
			for (int i = 0; i < str.length(); i++) {
				char tmp = str.charAt(i);
				if (Character.isLetter(tmp) != true) {
					sb.append(tmp);
				} else {
					sb.append(list.get(idx++));
				}
			}
			System.out.println(sb);

		}

	}

	private static void mergeSorting(char[] chr, int low, int high) {
		if (low >= high) {
			return;
		}
		int mid = (low + high) / 2;
		mergeSorting(chr, low, mid);
		mergeSorting(chr, mid + 1, high);
		merge(chr, low, mid, high);
	}

	private static void merge(char[] chr, int low, int mid, int high) {
		int i = low;
		int j = mid + 1;
		int idx = 0;
		char[] tmp = new char[high - low + 1];
		for (; (i <= mid) && (j <= high); idx++) {
			// 按照自然数比大小
			// if(chr[i] <= chr[j]){
			// tmp[idx] = chr[i++];
			// }else{
			// tmp[idx] = chr[j++];
			// }
			// 按照题目要求比大小
			char tmpI = chr[i];
			if (Character.isUpperCase(chr[i])) {
				tmpI = (char) ('a' + (chr[i] - 'A'));
			}
			char tmpJ = chr[j];
			if (Character.isUpperCase(chr[j])) {
				tmpJ = (char) ('a' + (chr[j] - 'A'));
			}
			if (tmpI <= tmpJ) {
				tmp[idx] = chr[i++];
			} else {
				tmp[idx] = chr[j++];
			}
		}

		while (i <= mid) {
			tmp[idx++] = chr[i++];
		}
		while (j <= high) {
			tmp[idx++] = chr[j++];
		}
		for (int k = 0; k < tmp.length; k++) {
			chr[low + k] = tmp[k];
		}
		return;
	}

	/**
	 * <p>题目描述 假设一个球从任意高度自由落下，每次落地后反跳回原高度的一半; 再落下, 求它在第5次落地时，共经历多少米?第5次反弹多高？
	 * 
	 * <p>最后的误差判断是小数点6位
	 * 
	 * 
	 * 
	 * <p>输入描述: 输入起始高度，int型
	 * 
	 * <p>输出描述: 分别输出第5次落地时，共经过多少米第5次反弹多高
	 * 
	 * <p>示例1 输入 复制 1 输出 复制 2.875 0.03125
	 */
	@Test
	public void testBallDecline() {
		BigDecimal startHigh = new BigDecimal("1");
		BigDecimal sum = new BigDecimal(0);
		BigDecimal divder = new BigDecimal(2);
		for(int i = 1; i <= 5; i++){
			if(i == 1){
				//第一次落地
				sum = sum.add(startHigh);
				//第一次反弹
				startHigh = startHigh.subtract(startHigh.divide(divder));
			}else{
				sum = sum.add(startHigh);
				sum = sum.add(startHigh);
				startHigh = startHigh.subtract(startHigh.divide(divder));
			}
		}
		//bigDecimal.toPlainString() 普通计数法
		String resSum = sum.setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
		String resHigh = startHigh.setScale(6, BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
		String tests = new BigDecimal("100000000040000").stripTrailingZeros().toString();
		//科学计数法格式化设置  
		//利用BigDecimal进行高精度计算，并根据精度确定最后的结果，结果控制为普通计数法格式
		//如果有转为科学计数法的需要，则利用DecimalFormat来控制科学计数法的精度，如下所示
		DecimalFormat decimalFormat = new DecimalFormat("0.##E0");
        String value = decimalFormat.format(new BigDecimal("14569000045434.266"));
		System.out.println(resSum+" "+resHigh+" "+tests+" "+value );
		
		//求解立方根
		double ss = Math.pow(27.0, 1.0/3);
		System.out.println(ss);
		
	}
	
	/**
	 * 获取最长递增子序列
	 * @param arr
	 * @return
	 */
	public static int getLISTX(int[] arr){
		//int[] arr = new int[]{2,5,1,5,4,5};
		int res = 1;
		int[] dp = new int[arr.length];
		
		for(int i = 0; i < arr.length; i++){
			dp[i] = 1;
			for(int j = 0; j < i; j++){
				if(arr[i] > arr[j] && dp[i] < (dp[j] + 1)){
					dp[i] = dp[j] + 1;
				}
			}
			res = Math.max(res, dp[i]);
		}
		
		return res;
		
	}
	
	/**
	 * Top K问题
	 * @param points
	 * @param K
	 * @return
	 */
	public int[][] kClosest(int[][] points, int K) {
		Comparator<Point> comparator = new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				int res = -(o1.x*o1.x + o1.y*o1.y) - (o2.x*o2.x + o2.y*o2.y);
				return res;
			}
			
		};
		//队头要存放最小元素，故比较器应该不同于常规（从小到大）排序方式
		PriorityQueue<Point> topKPool = new PriorityQueue<>(comparator);
		for(int i = 0, len = points.length; i < len; i++){
			Point pTmp = new Point(points[0][0], points[0][1]);
			topKPool.add(pTmp);
			if(topKPool.size() > K){
				topKPool.poll();
			}
		}
		
		return points;
		
	}
	
	/**
	 * 求解立方根漏洞百出
	 */
	public static void getCubeRoot(){
		Scanner scan = new Scanner(System.in);
		String strOfNum = scan.nextLine();
		Double num = new Double(strOfNum);
		boolean isLessZero = false;
		if(num < 0){
			num = -num;
			isLessZero = true;
		}
		if(num.intValue() == 1){
			System.out.println(1);
			return;
		}
		int mut = 1;
		double left = 0,right = num;
		if(num < 1){
			left = num;
			right = 1.0;
		}
		double mid = 0;
		while( num/mut > 0.0001 ){
			mut *= 2;
			mid = (right + left)/2;
			if(Math.pow(mid, 3) > num){
				right = mid;
			}else{
				left = mid;
			}
		}
		if(isLessZero == true){
			mid = -mid;
		}
		System.out.println(new BigDecimal(mid).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue());
		System.out.println(new BigDecimal(mid));
		
	}
	

}
