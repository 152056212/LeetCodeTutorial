package com.nsc.sjg;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

import org.junit.Test;

public class JUnit_AL {

	public static Scanner scan = new Scanner(System.in);
	
	@Test
	public void test(){
		System.out.println();
	}
	
	public static MTreeNode createTree(MTreeNode root, int next){
		if(root == null){
			root = new MTreeNode(next);
			return root;
		}else{
			if(next <= root.value){
				root.left = createTree(root.left, next);
			}else{
				root.right = createTree(root.right, next);
			}
		}
		return root;
	}
	
	public static void leftMove(MTreeNode root){
		Deque que = new LinkedList<MTreeNode>();
		que.offerLast(root);
		while(!que.isEmpty()){
			//当前的层数
			int curSize = que.size();
			int[] curValue = new int[curSize];
			//取队头
			MTreeNode cur = (MTreeNode) que.pollFirst();
			if(cur.left != null){
				que.offerLast(cur.left);
			}
			if(cur.right != null){
				que.offerLast(cur.right);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String line1 = scan.nextLine();
        String line2 = scan.nextLine();
        String[] arrs = line1.split(" ");
        String[] arrNums = line2.split(" ");
        int size = Integer.valueOf(arrs[0]);
        int[] nums = new int[size];
        int k = Integer.valueOf(arrs[1]);
        for(int i = 0; i < size; i++){
        	nums[i] = Integer.parseInt(arrNums[i]);
        }
        MTreeNode root = new MTreeNode(nums[0]);
        for(int i = 1; i < nums.length; i++){
        	createTree(root, nums[i]);
        }
        
        
	}
}
class MTreeNode{
	public int value;
	public MTreeNode left;
	public MTreeNode right;
	public MTreeNode(int value){
		this.value = value;
	}
}
