package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1197_최소스패닝트리 {
	static int V,E,ans;
	static List<Edge>[] table;
	static boolean[] visited;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		ans = 0;
		table = new ArrayList[V+1];
		for(int i =0; i< V+1; i++) {
			table[i] =new ArrayList<>();
		}
		visited = new boolean[V+1];
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			table[from].add(new Edge(to,weight));
			table[to].add(new Edge(from,weight));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(1,0));
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int to = edge.to;
			int weight = edge.weight;
			if(visited[to]) continue;
			visited[to] = true;
			ans += weight;
			for(int i = 0; i < table[to].size(); i++) {
				if(!visited[table[to].get(i).to]) {
					pq.add(table[to].get(i));
				}
			}
		}
		System.out.println(ans);
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
