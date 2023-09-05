package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import backj.BOJ_1197_최소스패닝트리.Edge;


public class BOJ_1238_파티2 {
	static int N,M,X;
	static List<Edge>[] nList,rList;
	static boolean[] visited;
	static int INF = 1000000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		nList = new ArrayList[N+1];
		rList = new ArrayList[N+1];
		for(int i = 0; i < N+1; i++) {
			nList[i] = new ArrayList<>();
			rList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			nList[from].add(new Edge(to,weight));
			rList[to].add(new Edge(from,weight));
			
		}
		
		
		int[] go = dijkstra(nList,X);
		int[] back = dijkstra(rList,X);
		
		int res = Integer.MIN_VALUE;
		for(int i = 1; i < N+1; i++) {
			int dis = go[i] + back[i];
			
			if(dis > res) res = dis;
		}
		System.out.println(res);
	}
	
	static int[] dijkstra(List<Edge>[] list, int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[N+1];
		int[] dp = new int[N+1];
		Arrays.fill(dp, INF);
		
		pq.add(new Edge(start,0));
		dp[start] = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			
			int to  = now.to;
			if(visited[to]) continue;
			visited[to] = true;
			
			for(Edge next : list[to]) {
				if(dp[to] + next.weight < dp[next.to]) {
					dp[next.to] = dp[to] + next.weight;
					pq.add(new Edge(next.to, dp[next.to]));
				}
			}
		}
		return dp;
	}
	static class Edge implements Comparable<Edge>{
		int to,weight;
		
		public Edge(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
}
