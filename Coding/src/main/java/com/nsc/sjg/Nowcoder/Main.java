package com.nsc.sjg;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
        for (int g = 0; g < 100; g++) {
            Scanner in = new Scanner(System.in);
            System.out.println("\n请输入年份：");
            int year = in.nextInt();
            System.out.println("请输入月份：");
            int month = in.nextInt();
            int sum = 0;
            int k = 0;
            for (int i = 1; i <= month - 1; i++) {
                if (i == 2) {
                    if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                        sum = sum + 29;
                    } else {
                        sum = sum + 28;
                    }
                } else {
                    if (i == 4 || i == 6 || i == 9 || i == 11) {
                        sum = sum + 30;
                    } else {
                        sum = sum + 31;
                    }
                }
            }
            for (int a = 1900; a <= year - 1; a++) {
                if (a % 4 == 0 && a % 100 != 0 || a % 400 == 0) {
                    sum = sum + 366;
                } else {
                    sum += 365;
                }
            }
            sum += 1;
            int wekday = sum % 7;
            System.out.println("日\t一\t二\t三\t四\t五\t六");
            for (int j = 1; j <= wekday; j++) {
                System.out.print("\t");
            }
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
                if (month == 2) {
                    k = 29;
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    k = 30;
                } else {
                    k = 31;
                }
            } else {
                if (month == 2) {
                    k = 28;
                } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                    k = 30;
                } else {
                    k = 31;
                }
            }
            for (int i = 1; i <= k; i++) {
                if (sum % 7 == 6) {
                    System.out.print(i + "\n");
                } else {
                    System.out.print(i + "\t");
                }
                sum++;
            }
        }
    }
	
	public static void mains(String[] args) {
		Scanner sc = new Scanner(System.in);
        //数组大小
        int size = sc.nextInt();
        int[] arr = new int[size];
        int i = 0;
        while(sc.hasNext()){
            arr[i++] = sc.nextInt();
            if(i > size - 1){
                break;
            }
        }
        int sum = quickSort(arr, 0, size - 1);
        System.out.print(sum);
        
//		Scanner sc = new Scanner(System.in);
//        int l = sc.nextInt();
//        int r = sc.nextInt();
//        int k = sc.nextInt();
//        Double sum = 0.0;
//        for(int i = l; i <= r; i++){
//            sum = sum + getCubeRoot1(i+getPow(10.0, k)) - getCubeRoot1(i*1.0);
//        }
//        System.out.println(sum);
        
	}
	
    public static double getPow(Double num, int k){
        return Math.pow(num, -k);
    }
    
    public static double getCubeRoot1(Double num){
        Double mid = Math.pow(num, 0.333333333);
		return new BigDecimal(mid).setScale(6, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	public static Double cubeRoot(Double i){
		Double res = new Double(0);
//		for(int i ){
//			
//		}
		
		return res;
	}
	
	
	
	public static int quickSort(int[] arr, int low, int high){
		int res = 0;
		if(high - low != arr.length - 1){
			for(int i = low; i <= high; i++ ){
				res += arr[i];
			}
		}
		if(low >= high){
			if(high == arr.length - 1){
				res += arr[high];
			}
			return res;
		}
		int left = low - 1, right = high + 1;
		int mid = 0;
		while(true){
			mid = (left + right) / 2;
			while(arr[++left] < arr[mid]);
			while(arr[--right] > arr[mid]);
			if(left >= right){
				break;
			}
			int tmp = arr[left];
			arr[right]= arr[left];
			arr[left] = tmp;
		}
		return quickSort(arr, low, left - 1) + quickSort(arr, right+1, high);
	}
	
	public static double getCubeRoot(Double num){
		boolean isLessZero = false;
		if(num < 0){
			num = -num;
			isLessZero = true;
		}
		if(num.intValue() == 1){
			System.out.println(1);
			return 0.0;
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
		return new BigDecimal(mid).setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
		
	}
	
	
}
