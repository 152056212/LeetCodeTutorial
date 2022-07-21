package com.nsc.sjg;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class Junit_MT {

	public static Scanner scan = new Scanner(System.in);

	@Test
	public void test() {
		String line1 = scan.nextLine();
		String[] arr1 = line1.split(" ");
		int n = Integer.parseInt(arr1[0]);
		int m = Integer.parseInt(arr1[1]);
		int k = Integer.parseInt(arr1[2]);
	
		
		String nm = n+""+m;
		boolean isReturn = true;
		int[] vexset = new int[n*m];
		Graph g = new Graph();
		String[] vexs = new String[n*m];
        for(int i = 0; i < n*m; i++){
        	vexs[i] = String.valueOf(i);
        }
		g.vexnum = n*m;
		g.arcnum = k;
		Edge[] edges = new Edge[k];
		for(int i = 0; i < k; i++){
			String tmpArr = scan.nextLine();
			
			String[] arrTmp = tmpArr.split(" ");
			String key = arrTmp[0]+arrTmp[1]+arrTmp[2]+arrTmp[3];
			Edge tmp = new Edge();
			tmp.head = arrTmp[0]+arrTmp[1];
			tmp.tail = arrTmp[2]+arrTmp[3];
			tmp.lowcost = Integer.parseInt(arrTmp[4]);
			if(key.contains(nm)){
				isReturn = false;
			}
			edges[i] = tmp;
		}
		
		if(isReturn == true){
			System.out.println(-1);
		}else{
			
			Arrays.sort(edges);
			for(int i = 0; i < g.vexnum; i++){
				vexset[i] = i;
			}
			int cost = 0;
			for(int i = 0; i < g.arcnum; i++){
				int v1Id = g.getId(edges[i].head);
				int v2Id = g.getId(edges[i].tail);
				int vs1 = vexset[v1Id];
				int vs2 = vexset[v2Id];
				if(vs1 != vs2){
					cost+=edges[i].lowcost;
					for(int j = 0; j < g.arcnum; j++){
						if(vexset[j] == vs2){
							vexset[j] = vs1;
						}
					}
				}
			}
			System.out.println(cost);
			
		}
	
		
	}
	
	public void testMST(){
		
		Scanner scan = new Scanner(System.in);
        String line1 = scan.nextLine();
		String[] arr1 = line1.split(" ");
		int n = Integer.parseInt(arr1[0]);
		int m = Integer.parseInt(arr1[1]);
		int k = Integer.parseInt(arr1[2]);
        
		
		
	}
	
	
	public static void main1(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int h = s.nextInt();
		int[] hN = new int[n];
		for (int i = 0; i < n; i++) {
			hN[i] = s.nextInt();
		}
		int start = 0;
		while (start <= n - m) {
			if (hN[start] > h) {
				start += 1;
				continue;
			} else {
				int nextNum = 0;
				for (nextNum = 1; nextNum < m; nextNum++) {
					if (hN[start + nextNum] > h) {
						start += nextNum;
						break;
					}
				}
				if (nextNum == 3) {
					System.out.println(start + 1);
					return;
				}
				start += 1;
			}
		}
		System.out.println(-1);
	}

}

class Edge implements Comparable<Edge>{
	public String head;
	public String tail;
	public int lowcost;
	
	@Override
	public int compareTo(Edge o) {
		return this.lowcost - o.lowcost;
	}
}
class Graph{
	public String[] vexs;//顶点集
	public int vexnum;//点数
	public int arcnum;//边数
	
	public int getId(String vex){
		for(int i = 0, len = this.vexs.length; i < len;i++){
			if(vex.contentEquals(this.vexs[i])){
				return i;
			}
		}
		return -1;
	}
}
