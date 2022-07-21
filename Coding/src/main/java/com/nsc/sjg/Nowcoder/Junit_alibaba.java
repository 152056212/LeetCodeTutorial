package com.nsc.sjg;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.Test;

public class Junit_alibaba {
	public static Scanner scan = new Scanner(System.in);
	
	@Test
	public void test(){
		int n = scan.nextInt();
		int[] as = new int[2*n];
		int i = 0;
		while(scan.hasNext()){
			as[i++] = scan.nextInt();
			if(i == 2*n){
				break;
			}
		}
		Arrays.sort(as);
		int min1 = as[0];
		int max1 = as[2*n - 1];
        int key = max1 - min1;
        int min = Integer.MAX_VALUE;
        for(int k = 1; k < 2*n - 1 - 1; k++){
        	if(Math.abs((key - as[k]))*1.0 < min){
        		min =  (int) (Math.abs((key - as[k]))*1.0);
        	}
        }
        
		System.out.println( min );
	}
	
	public void testMST(){
		int[] vexset = new int[2];
		Graph g = new Graph();
		g.vexnum = 2;
		g.arcnum = 0;
		Edge[] edges = new Edge[2];
		Arrays.sort(edges);
		for(int i = 0; i < g.vexnum; i++){
			vexset[i] = i;
		}
		
		for(int i = 0; i < g.arcnum; i++){
			int v1Id = g.getId(edges[i].head);
			int v2Id = g.getId(edges[i].tail);
			int vs1 = vexset[v1Id];
			int vs2 = vexset[v2Id];
			if(vs1 != vs2){
				for(int j = 0; j < g.arcnum; j++){
					if(vexset[j] == vs2){
						vexset[j] = vs1;
					}
				}
			}
		}
	}
	
}


//class Edge implements Comparable<Edge>{
//	public char head;
//	public char tail;
//	public int lowcost;
//	
//	@Override
//	public int compareTo(Edge o) {
//		return this.lowcost - o.lowcost;
//	}
//}
//class Graph{
//	public char[] vexs;//顶点集
//	public int vexnum;//点数
//	public int arcnum;//边数
//	
//	public int getId( char vex){
//		for(int i = 0, len = this.vexs.length; i < len;i++){
//			if(vex == this.vexs[i] ){
//				return i;
//			}
//		}
//		return -1;
//	}
//}

