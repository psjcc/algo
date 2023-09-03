package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_27945_가지가지하노 {
	static List<Edge>[] table;
 	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N+1];
		table = new ArrayList[N+1];
		
		for(int  i = 1; i < N+1; i++) table[i] = new ArrayList<>();
		int start = 1;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int date = Integer.parseInt(st.nextToken());
			if(date == 1) start = from;
			table[from].add(new Edge(to,date));
			table[to].add(new Edge(from,date));
		}
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		pq.add(new Edge(start,0));
		int days = 0;
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int to = now.to;
			int date = now.date;
			if(visited[to]) continue;
//			System.out.println(to);
			if(date != days) {break;}      		
			else days++;
			visited[to] = true;
			for(int i = 0; i < table[to].size(); i++) {
				if(!visited[table[to].get(i).to])
					pq.add(table[to].get(i));
			}
		}
//		days--;
		System.out.println(days);
	}
 	static class Edge implements Comparable<Edge>{
 		int to, date;
 		
 		public Edge(int to, int date) {
 			this.to = to;
 			this.date = date;
 		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.date - o.date;
		}
 		
 	}
}
