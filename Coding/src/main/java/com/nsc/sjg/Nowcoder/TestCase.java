package com.nsc.sjg;

import java.math.BigInteger;
import java.util.Scanner;

public class TestCase {

	public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //int T = Integer.parseInt(scan.nextLine());
        //String[] arr = scan.nextLine().split(" ");
        //quickSort(arr, 0, arr.length - 1);
        while(scan.hasNext()){
        	String[] arr = scan.nextLine().split(" ");
        	BigInteger a = new BigInteger(arr[0]);
        	BigInteger b = new BigInteger(arr[1]);
            System.out.println(a.add(b));
        }
    }

    public static void quickSort(String[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int left = low - 1, right = high + 1;
        String tmp;
        while(true){
            int mid = (left+right) / 2;
            while(arr[++left].compareTo(arr[mid]) < 0);
            while(arr[--right].compareTo(arr[mid]) > 0);
            if(left < right){
                tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }else{
                break;
            }
        }
        quickSort(arr, low, left-1);
        quickSort(arr, right+1, high);
    }

}
