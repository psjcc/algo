package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_10217_KCMtravel {
	static int N,M,K;
	static ArrayList<Edge>[] al;
	static boolean[] check;
	static int[][] dist;
	static int INF = 100000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testcase = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<= testcase; tc++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken())-1;
			
			check = new boolean[N];
			al = new ArrayList[N];
			dist = new int[N][10001];
			al[0] = new ArrayList<>();
			for(int i = 1; i < N; i++) {
				al[i] = new ArrayList<>();
				Arrays.fill(dist[i], INF);
			}
			
			for(int i = 0; i < K ; i++) {
				st = new StringTokenizer(br.readLine());
				
				int from = Integer.parseInt(st.nextToken())-1;
				int to = Integer.parseInt(st.nextToken())-1;
				int cost = Integer.parseInt(st.nextToken());
				int distance = Integer.parseInt(st.nextToken());
				
				al[from].add(new Edge(to,cost,distance));
			}
			
			dijkstra(0);
			
			int res = INF;
			
			for(int i = 0; i < M; i++) {
				if(res > dist[N][i]) {
					res = dist[N][i];
				}
			}
			
			if(res == INF) System.out.println("Poor KCM");
			else System.out.println(res);
		}
	}
	
	static void dijkstra(int c) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(c,0,0));
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			if(dist[edge.to][edge.cost] < edge.distance) continue;
			
			for(int i = 0; i < al[edge.to].size(); i++) {
				int total_cost = edge.cost + al[edge.to].get(i).cost;  
				if(total_cost > M) continue;
				
				int distance = al[edge.to].get(i).distance+ edge.distance;
				if(distance < dist[al[edge.to].get(i).to][total_cost] ) {
					dist[al[edge.to].get(i).to][total_cost] = distance;
					pq.offer(new Edge(al[edge.to].get(i).to, total_cost, distance));
				}
			}
		}
	}
	
	static class Edge{
		int to, cost, distance;

		public Edge(int to, int cost, int distance) {
			super();
			this.to = to;
			this.cost = cost;
			this.distance = distance;
		}
		
	}
}