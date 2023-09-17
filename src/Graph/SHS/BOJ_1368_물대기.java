package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1368_물대기 {
	static List<Edge>[] table;
	static boolean[] visited;
	static int ans;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		table = new ArrayList[N+1];
		visited = new boolean[N+1];
		ans = 0;
		
		for(int i = 0; i < N+1; i++){
			table[i] = new ArrayList<>();
		}
		
		for(int i = 1; i < N+1; i++) {
			int to_well = Integer.parseInt(br.readLine());
			table[0].add(new Edge(i,to_well));
			table[i].add(new Edge(0,to_well));
		}
		
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j < N+1; j++) {
				if(i == j) continue;
				int weight = Integer.parseInt(st.nextToken());
				table[i].add(new Edge(j,weight));
			}
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(0,0));
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int to = now.to;
			int weight = now.weight;
			
			if(visited[to]) continue;
			ans += weight;
			visited[to] = true;
			
			System.out.println(to);
			for(int i = 1; i < N+1; i++) {
				pq.add(table[to].get(i));
			}
		}
		
		System.out.println(ans);
	}
	static class Edge implements Comparable<Edge>{
		int to, weight;
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
