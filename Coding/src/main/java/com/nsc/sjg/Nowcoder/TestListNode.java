package com.nsc.sjg;

import java.util.Objects;

public class TestListNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sss");

	}

	/**
	 * 合并两个有序列表
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoNodeList(ListNode l1, ListNode l2) {
		if (Objects.isNull(l1)) {
			return l2;
		}

		if (Objects.isNull(l2)) {
			return l1;
		}

		if (l1.val < l2.val) {
			l1.next = mergeTwoNodeList(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoNodeList(l1, l2.next);
		}

		return null;
	}

	static class ListNode {
		public int val;
		public ListNode next;
	}

	public void quicksort(int[] arr, int low, int high) {
		if (low > high) {
			return;
		}
		int left = low - 1;
		int right = high + 1;
		while (true) {
			int mid = (left + right) / 2;
			while (arr[++left] < arr[mid])
				;
			while (arr[--high] > arr[mid])
				;
			if (left > high) {
				break;
			}
			int tmp = arr[left];
			arr[left] = arr[high];
			arr[high] = arr[left];
		}
		quicksort(arr, low, left - 1);
		quicksort(arr, right + 1, high);
	}

}
