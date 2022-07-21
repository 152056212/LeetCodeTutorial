package com.nsc.sjg;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.junit.BeforeClass;
import org.junit.Test;

public class JUnit0411_BD {

	public static Scanner scan = new Scanner(System.in);

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
//		int count = Integer.valueOf(scan.nextLine());
//		while(count != 0){
//			String str = scan.nextLine();
//			String[] vals = str.split(" ");
//			int a = Integer.valueOf(vals[0]);
//			int b = Integer.valueOf(vals[1]);
//			System.out.println(testLatest(a,b));
//		}
//		scan.close();
		System.out.println(testLatest(10,5));
	}
	public static int testLatest(int valA, int valB){
		double i = 0;
		int idA = 0;
		while(true){
			int startA = (int) Math.pow(2.0, i);
			int startB = (int) Math.pow(2.0, i+1);
			if(valA >= startA && valA < startB){
				break;
			}else{
				i++;
			}
		}
		//A参数在第idA层
		idA = (int)i;
		i = 0;
		int idB = 0;
		while(true){
			int startA = (int) Math.pow(2.0, i);
			int startB = (int) Math.pow(2.0, i+1);
			if(valB >= startA && valB < startB){
				break;
			}else{
				i++;
			}
		}
		//B参数在第idB层
		idB = (int)i;
		//System.out.println(idA+" "+idB);
		List<Integer> listA = new ArrayList<>(); 
		StringBuilder sbA = new StringBuilder();
		int tmpA = valA;
		while(tmpA > 1){
			listA.add(tmpA/2);
			sbA.append(""+tmpA/2);
			tmpA = tmpA/2;
		}
		List<Integer> listB = new ArrayList<>(); 
		StringBuilder sbB = new StringBuilder();
		int tmpB = valB;
		while(tmpB > 1){
			listB.add(tmpB/2);
			sbB.append(""+tmpB/2);
			tmpB = tmpB/2;
		}
		int sizeA = listA.size();
		int sizeB = listB.size();
		int curId = 0;
		//System.out.println(listA.size()+" "+listB.size());
		System.out.println(sbA);
		System.out.println(sbB);
		if(sizeA > sizeB){
			for(int k = 0; k < sizeB; k++){
				if(listA.get(k+sizeA-sizeB) == listB.get(k)){
					//找到公共祖先
					curId = k+1;
					break;
				}
			}
			
		}else{
			for(int k = 0; k < sizeA; k++){
				if(listB.get(k+sizeB-sizeA) == listA.get(k)){
					//找到公共祖先
					curId = k+1;
					break;
				}
			}
		}
		curId *= 2;
		curId += Math.abs(sizeA - sizeB);
		//System.out.println(curId);
		return curId;
	}
	
	//@Test
	public void test02(){
		String line1 = scan.nextLine();
		String[] nums = line1.split(" ");
		//参赛选手数量
		int n = Integer.valueOf(nums[0]);
		//比赛场次
		int m = Integer.valueOf(nums[1]);
		//编号
		int id = Integer.valueOf(nums[2]);
		int i = 1;
		Set<Integer> set = new TreeSet<>();
		while(i != m){
			
			
			i++;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
