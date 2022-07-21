package com.nsc.sjg;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

import org.junit.BeforeClass;
import org.junit.Test;

public class JUnit0410_WY {

	public static Scanner scan = new Scanner(System.in);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

	}

	// @Test
	public void test() {
		// Iterator iter = map.entrySet().iterator();
		// while (iter.hasNext()) {
		// Map.Entry entry = (Map.Entry) iter.next();
		// Integer k = (Integer) entry.getKey();
		// Integer v = (Integer) entry.getValue();
		// System.out.println(k + " " + v);
		// }
		// StringBuffer sb=new StringBuffer(s);
		// System.out.println(sb.reverse());
		// BitSet used = new BitSet(129);
		// TreeMap<Integer, Integer> map = new TreeMap<>();
		// String resHigh = startHigh.setScale(6,
		// BigDecimal.ROUND_HALF_UP).stripTrailingZeros().toPlainString();
		// String tests = new
		// BigDecimal("100000000040000").stripTrailingZeros().toString();
		// DecimalFormat decimalFormat = new DecimalFormat("0.##E0");
		// String value = decimalFormat.format(new
		// BigDecimal("14569000045434.266"));
		// System.out.println(resSum+" "+resHigh+" "+tests+" "+value );
		// double ss = Math.pow(27.0, 1.0/3);
		// PriorityQueue<Point> topKPool = new PriorityQueue<>(comparator);
	}

	@Test
	public void test01() {
//		int[] test = new int[] {5,10,10,10,20};
//		System.out.println(billsChange(test));
	}

	public int billsChange(int[] bills) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(5, 2);
		map.put(10, 0);
		map.put(20, 0);
		int res = 0;
		for (int i = 0; i < bills.length; i++) {
			if (bills[i] == 5) {
				map.put(5, map.get(5) + 1);
				res+=1;
			} else {
				if (bills[i] == 10) {
					// 先支付
					map.put(10, map.get(10) + 1);
					// 后找零
					int conutOf5 = map.get(5);
					if (conutOf5 < 1) {
						res = i;
						break;
					}
					map.put(5, conutOf5 - 1);

				} else {
					// 先支付
					map.put(20, map.get(20) + 1);
					// 后找零
					int conutOf5 = map.get(5);
					int countOf10 = map.get(10);
					if(conutOf5 < 3){
						//没有3张5的话
						if(conutOf5 >= 1 && countOf10 >= 1){
							map.put(5, conutOf5 - 1);
							map.put(10, countOf10 - 1);

						}else{
							//没有1张5和一张10
							res = i;
							break;
							
						}
					}else{
						map.put(5, conutOf5 - 3);
					}
					
				}
			}
		}

		return res;
		// write code here

	}

	public ListNode minusList (ListNode minuendList, ListNode subtrahendList) {
		
		StringBuilder sbMin = new StringBuilder(1000);
		ListNode tmp = minuendList;
		while(tmp != null){
			sbMin.append(tmp.val);
			tmp = tmp.next;
		}
		StringBuilder sbSub = new StringBuilder(1000);
		tmp = subtrahendList;
		while(tmp != null){
			sbSub.append(tmp.val);
			tmp = tmp.next;
		}
		
		BigInteger min = new BigInteger(sbMin.toString());
		BigInteger sub = new BigInteger(sbSub.toString());
		String rs = min.subtract(sub).toString();
		ListNode resNode = new ListNode(0);
		if(rs.charAt(0) == '-'){
			resNode.val = Integer.valueOf(rs.substring(0, 2));
			tmp = resNode;
			for(int i = 2; i < rs.length(); i++){
				tmp.next = new ListNode( Integer.valueOf(rs.substring(i, i+1)) );
				tmp = tmp.next;
			}
		}else{
			resNode.val = Integer.valueOf(rs.substring(0, 1));
			tmp = resNode;
			for(int i = 1; i < rs.length(); i++){
				tmp.next = new ListNode( Integer.valueOf(rs.substring(i, i+1)) );
				tmp = tmp.next;
			}
		}
		
		return resNode;
        // write code here
        
    }

	/**
	 * 
	 * @param e 第i个冲多少电
	 * @param c 从i个到下一个花费多少
	 * @return
	 */
	public int canCompleteRace (int[] e, int[] c) {
		if(e.length == 0){
			return -1;
		}
		TreeSet<Integer> res = new TreeSet<>();
		for(int i = 0; i < e.length; i++){
			int tmp = testCompleteRace(e, c, i);
			if(tmp == -1){
				continue;
			}else{
				res.add(tmp);
			}
		}
		return res.size() > 0 ? res.first() : -1;
        // write code here
        
    }
	public static int testCompleteRace(int[] e, int[] c, int startId){
		
		int curEng = 0;
		int endId = e.length;
		int nextId = startId;
		while(endId != 0){
			//先充电
			curEng += e[nextId];
			//后运动
			if(curEng >= c[nextId]){
				//运动到下一位置
				curEng -= c[nextId];
				nextId = (nextId+1)%e.length;
			}else{
				break;
			}
			endId--;
		}
		
		return endId == 0 ? startId : -1;
	}
	
	/**
	 * 归并排序-排序
	 * @param arr
	 * @param low
	 * @param high
	 */
	public void mergeSorting(int[] arr, int low, int high){
		if(low >= high){
			return;
		}
		int mid = (low+high)/2;
		mergeSorting(arr, low, mid);
		mergeSorting(arr, mid+1, high);
		merge(arr, low, mid, high);
	}
	/**
	 * 归并排序-归并
	 * @param arr
	 * @param low
	 * @param mid
	 * @param high
	 */
	public void merge(int[] arr, int low, int mid, int high){
		//左路指针
		int i = low;
		//右路指针
		int j = mid+1;
		int[] tmp = new int[high-low+1];
		int idx = 0;
		for(; i <= mid && j <= high; idx++){
			if(arr[i] <= arr[j]){
				tmp[idx] = arr[i++];
			}else{
				tmp[idx] = arr[j++];
			}
			
		}
		while(i <= mid){
			tmp[idx++] = arr[i++];
		}
		while(j <= high){
			tmp[idx++] = arr[j++];
		}
		
		for(int k = 0; k < tmp.length; k++){
			arr[low+k] = tmp[k];
		}
		
	}

}



//class ListNode {
//	int val;
//	ListNode next = null;
//
//	public ListNode(int val) {
//		this.val = val;
//	}
//	
//}























