package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1238_파티 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, X;
	static int answer = 0;
	static final int INF = Integer.MAX_VALUE;
	static ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
	
	static boolean[] visited;
	static int[] cost;
	
	
	static PriorityQueue<Edge> heap = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
	
	
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
	
	
	public static void D(int start, int[] cost, boolean[] visited) {
		cost[start] = 0;
		heap.offer(new Edge(start, start, 0));
		
		while(!heap.isEmpty()) {
			Edge cur = heap.poll();
			
			if(visited[cur.to]) continue;
			visited[cur.to] = true;
			
			for(Edge next : adjList.get(cur.to)) {
				if(next.cost + cost[cur.to] < cost[next.to]) {
					cost[next.to] = next.cost + cost[cur.to];
					heap.offer(new Edge(cur.to, next.to, next.cost + cost[cur.to]));
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		
		
		for(int i = 0; i < N + 1; i++) {
			adjList.add(new ArrayList<Edge>());
		}
		
		for(int i = 0; i < M ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			
			adjList.get(from).add(new Edge(from, to, cost));
			
		}
		
		visited = new boolean[N + 1];
		cost = new int[N + 1];
		int[] costFromX = new int[N + 1];
		for(int i = 0; i < N + 1; i++) {
			costFromX[i] = INF;
		}
		D(X, costFromX, visited);
		
//		System.out.println(Arrays.toString(costFromX));
		for(int s = 1; s <= N; s++) {
			visited = new boolean[N + 1];
			for(int i = 0; i < N+1 ; i++) {
				cost[i] = INF;
			}
			D(s, cost, visited);
//			System.out.println(Arrays.toString(cost));
			answer = Math.max(answer, costFromX[s] + cost[X]);
		}
		System.out.println(answer);
		
		
		
		

	}

}
