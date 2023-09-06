package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_1197_최소신장트리 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int V, E;
	static ArrayList<Edge> edgeList = new ArrayList<>();
	static int[] parent;
	static int answer = 0;
	
	static class Edge{
		int from;
		int to;
		int weight;
		Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
			
		}
	}
	
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
	
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edgeList.add(new Edge(from, to, weight));
		}
		
		Collections.sort(edgeList, (o1, o2) -> o1.weight - o2.weight);
		
		makeSet(V);
		for(Edge e : edgeList) {
			if(union(e.from, e.to)) {
				answer += e.weight;
			}
		}
		
		System.out.println(answer);
		
		
		

	}

}
