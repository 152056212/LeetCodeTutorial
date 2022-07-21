package com.nsc.sjg;

import java.util.Scanner;

public class Junit_tx02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test01();
	}
	
	public void test03(){
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        double x3 = 1.6,y3 = 0;
        double x1 = 1.0,y1 = 0;
        double r1 = 0;
        double sum = Math.sqrt(Math.abs(y3-y1)) + Math.sqrt(Math.abs(x3-x1)); 
        double x1Tox3 = Math.pow(sum, 0.5);
        double r2 = (r1+x1Tox3)/2.0;
        
	}
	public static  void test01(){
		Scanner scan = new Scanner(System.in);
		int appleNum = scan.nextInt();
		int quesNum = scan.nextInt();
		int[] appleWeight = new int[appleNum];
		int[] ques = new int[quesNum];
		for(int i= 0; i< appleNum; i++){
			appleWeight[i] = scan.nextInt();
			
		}
		for(int i = 0; i < quesNum; i++){
			ques[i] = scan.nextInt();
		}
		int[] res = new int[2];
		for(int i = 0; i < quesNum; i++){
			res = twoSub(appleWeight, ques[i]);
			String resTmp = res[0]+" "+res[1];
			System.out.println(resTmp);
		}
		
	}
	public static int[] twoSub(int[] nums, int tar){
		int n = nums.length;
		for(int i = 0; i < n; i++){
			for(int j = i+1; j < n; j++){
				if(Math.abs(nums[i] - nums[j]) == tar){
					return new int[]{nums[i], nums[j]};
				}
			}
		}
		int[] res = new int[]{-1, -1};
		return res;
	}

}
