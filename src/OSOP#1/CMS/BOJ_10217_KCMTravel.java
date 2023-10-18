package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
	
public class BOJ_10217_KCMTravel {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] score;
	static int T;
	static int N, M, K;
	static ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
	static final int INF = Integer.MAX_VALUE;
	static boolean[] V;
	static int answer = Integer.MAX_VALUE;
	
	
	static class Edge{
		int u;
		int v;
		Cost cost;
		Edge(int u, int v, Cost cost){
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
	}
	
	static class Cost{
		int c;
		int d;
		
		Cost(int c, int d){
			this.c = c;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Cost [c=" + c + ", d=" + d + "]";
		}
		
	}
	
	public static void dijk(int start, Cost[] cost, boolean[] visited) {
		
		cost[start].c = 0;
		cost[start].d = 0;
		PriorityQueue<Edge> heap = new PriorityQueue<>((o1, o2) -> o1.cost.d - o2.cost.d);
		
		heap.offer(new Edge(start, start, new Cost(0, 0)));
		
		
		while(!heap.isEmpty()) {
			Edge cur = heap.poll();
			
			if(visited[cur.v]) continue;
			visited[cur.v] = true;
			
			for(Edge next : adjList.get(cur.v)) {
				if(next.cost.d + cost[cur.v].d <= cost[next.v].d) {
					cost[next.v].d = next.cost.d + cost[cur.v].d; 
					if(cost[next.v].c != 0 && next.cost.c + cost[cur.v].c < cost[next.v].c ) {
						cost[next.v].c = next.cost.c + cost[cur.v].c; 
					}
					else {
						cost[next.v].c = next.cost.c + cost[cur.v].c; 
					}
					
					
					heap.offer(new Edge(cur.v, next.v, new Cost(cost[next.v].c, cost[next.v].d)));
				}
			}
			
			
		}
	}
	
	public static void dfs(int cur, int m, int t) {
		if(cur == N) {
			answer = Math.min(answer, t);
			return;
		}
		
		// 다익스트라
		
		Cost[] cost = new Cost[N + 1];
		boolean[] visited = new boolean[N + 1];
		for(int i = 0; i <= N; i++) {
			cost[i] = new Cost(0, INF);
//			if(V[i]) visited[i] = true;
		}
		
		dijk(cur, cost, visited); // => cost
		
		
		for(int i = 1; i <= N; i++) {
			if(cost[i].d == INF) continue;
			if(m + cost[i].c > M) continue;
			if(V[i]) continue;
			V[i] = true;
			dfs(i, m + cost[i].c, t + cost[i].d);
			V[i] = false;
		}
		
		// 1 -> 2
		
		// 1 -> 3 -> 2
		
		
	}
	
	public static void main(String[] args) throws Exception {
		
		T = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		V = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<Edge>());
		}
		
		
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			adjList.get(u).add(new Edge(u, v, new Cost(c, d)));
		}
		
		V[1] = true;
		dfs(1, 0, 0);
		
		
		System.out.println(answer == Integer.MAX_VALUE ? "Poor KCM" : answer);
		
		
		

	}

}