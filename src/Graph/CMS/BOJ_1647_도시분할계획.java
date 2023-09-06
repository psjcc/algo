package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1647_도시분할계획 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static ArrayList<Edge> edgeList = new ArrayList<>();
	static int[] parent;
	static int answer = 0;
	
	public static void makeSet(int n) {
		parent = new int[n + 1];
		for(int i = 0; i < n + 1; i++) {
			parent[i] = i;
		}
	}
	
	public static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	public static boolean union(int a, int b) {
		int aP = findSet(a);
		int bP = findSet(b);
		
		if(aP == bP) return false;
		else {
			parent[aP] = bP;
			return true;
		}
	}
	
	static class Edge{
		int from;
		int to;
		int cost;
		Edge(int from, int to, int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(from, to, cost));
		}
		
		Collections.sort(edgeList, (o1, o2) -> o1.cost - o2.cost);
		
		makeSet(N);
		int maxCost = 0;
		for(Edge e : edgeList) {
			if(union(e.from, e.to)) {
				answer += e.cost;
				if(maxCost < e.cost) {
					maxCost = e.cost;
				}
			}
		}
		
		System.out.println(answer - maxCost);
	}

}
