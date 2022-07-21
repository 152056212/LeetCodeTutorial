package com.nsc.sjg;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class JUnit0331_TX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Scanner in = new Scanner(System.in);
		// // while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
		// // int a = in.nextInt();
		// // int b = in.nextInt();
		// // System.out.println(a + b);
		// // }
		// // 使用n次
		// int n = in.nextInt();
		// // n个使用时刻
		// int[] useTime = new int[n]; 
		// int idx = 0, sum = 0, curTime = 0;
		// int[] dp = new int[n + 1];
		// dp[0] = 0;
		// while (in.hasNextInt()) {
		// int a = in.nextInt();
		// useTime[idx++] = a;
		// }
		// for (int i = 0; i <= n; i++) {
		// if (sum + 20 < 50 && useTime[i] < 100) {
		// sum = sum + 20;
		// dp[i] = sum;
		// continue;
		// }
		// if (sum + 20 >= 50 && useTime[i] < 100) {
		// int tmp = 50 - sum;
		// sum = sum + tmp;
		// dp[i] = 50 - sum;
		// continue;
		// }
		// if (sum + 20 < 100 && useTime[i] >= 100 && useTime[i] <= 1000) {
		// sum = sum + 20;
		// dp[i] = sum;
		// continue;
		// }
		// if (sum + 20 >= 100 && useTime[i] >= 100 && useTime[i] <= 1000) {
		// int tmp = 100 - sum;
		// sum = sum + tmp;
		// dp[i] = 100 - sum;
		// continue;
		// }
		// // dp[i]
		// }
		// for (int i = 1; i <= n; i++) {
		// System.out.println(dp[i]);
		// }
		//
		// // int n = sc.nextInt();
		// // int ans = 0, x;
		// // for(int i = 0; i < n; i++){
		// // for(int j = 0; j < n; j++){
		// // x = sc.nextInt();
		// // ans += x;
		// // }
		// // }
		// // System.out.println(ans);

		// 5
		Math.sqrt(0);
		//zj();
		//getInteger();
		//getLcm();
		//getCubeRoot();
		//System.out.println(getLIS());
//		Scanner scan = new Scanner(System.in);
//        while(scan.hasNext()){
//            int size = scan.nextInt();
//            int[] arr = new int[size];
//            for(int i = 0; i < size; i++){
//                arr[i] = scan.nextInt();
//            }
//            System.out.println(getLIS(arr));
//        }
		splitArray();
	}

	public static void seq() {
		Scanner in = new Scanner(System.in);
		// n组数据
		int n = in.nextInt();
		int count = 0;

		while (in.hasNext()) {
			// 序列大小
			int sizeOfSeq = in.nextInt();
			int[] arr = new int[sizeOfSeq];
			// 不参加交换的位置数量
			int noSwap = in.nextInt();
			int[] posNoSwap = new int[noSwap];
			for (int i = 0; i < sizeOfSeq; i++) {
				// 接收序列
				arr[i] = in.nextInt();
			}
			// 不参加交换的位置
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < noSwap; i++) {
				int tmp = in.nextInt();
				map.put(tmp, tmp);
			}
			judge(arr, map);

		}

	}

	public static boolean judge(int[] arr, Map<Integer, Integer> noSwapPosMap) {
		quickSort(arr, 0, arr.length, noSwapPosMap);
		int min = 0;
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void quickSort(int[] arr, int low, int high, Map<Integer, Integer> noSwapPos) {
		if (arr == null || low > high) {
			return;
		}
		int left = low - 1, right = high + 1;
		while (true) {
			int mid = (low + high) / 2;
			while (arr[++left] < arr[mid])
				;
			while (arr[--right] > arr[mid])
				;
			if (left > right) {
				break;
			}
			if (noSwapPos.get(left) != null && noSwapPos.get(right) != null) {
				int tmp = arr[left];
				arr[left] = arr[right];
				arr[right] = tmp;
			}

		}
		quickSort(arr, low, left - 1, noSwapPos);
		quickSort(arr, right + 1, high, noSwapPos);
	}

	public static void zj() {
		Scanner in = new Scanner(System.in);
		// n张彩票
		int n = in.nextInt();
		// m个开奖号码
		int m = in.nextInt();
		int[] cp = new int[n];

		// 开奖区
		Map<Integer, Integer> map = new HashMap<>();
		// 中奖号码
		int[] cpOK = new int[n];
		int idx = 0;
		while (in.hasNextInt()) {
			if (idx < n) {
				cp[idx++] = in.nextInt();
			} else {
				int tmp = in.nextInt();
				map.put(tmp, tmp);
				idx++;
			}
			if (idx >= n + m) {
				break;
			}
		}
		// 总金额
		int sum = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (map.get(cp[i]) != null) {
				sum += cp[i];
				cpOK[count] = cp[i];
				count++;
			}
		}
		System.out.println("ss" + count);
		for (int i = 0; i < count; i++) {
			System.out.print(cpOK[i]);
		}
		System.out.println();
		System.out.println(sum);

	}

	/**
	 * 输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。 保证输入的整数最后一位不是0。
	 */
	public static void getInteger() {
		Scanner in = new Scanner(System.in);
		String num = in.nextLine();
		StringBuilder res = new StringBuilder();
		int len = num.length();
		for(int i = len-1; i >= 0; i--){
			if(res.indexOf(num.substring(i, i+1)) == -1){
				res.append(num.substring(i, i+1));
			}
		}
		System.out.println(res);
	}
	
	/**
	 * 获取最小公倍数
	 */
	public static void getLcm(){
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		if(a == 0 || b == 0){
			System.out.println(0);
		}
		System.out.println(a*b/getGCD(a,b));
	}
	/**
	 * 获取最大公约数
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getGCD(int a, int b){
		if(b == 0){
			return a;
		}
		return getGCD(b, a%b);
	}
	
	

	
	public static void splitArray(){
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			int size = scan.nextInt();
			int sumOfFive = 0;
			int sumOfThree = 0;
			for(int i = 0; i < size; i++){
				int tmp = scan.nextInt();
				if(tmp%5 == 0){
					sumOfFive += tmp;
				}else{
					if(tmp%3 == 0 && tmp%5 != 0){
						sumOfThree += tmp;
					}
				}
			}
			if(sumOfFive == sumOfThree){
				System.out.println("true");
			}else{
				System.out.println("false");
				
			}
		}
	}
	
	
	
}
class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}