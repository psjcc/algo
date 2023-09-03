package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {
	static List<Edge>[] table;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		double[][] pos = new double[N+1][2];
		
		table = new ArrayList[N+1];
		for(int i = 1; i <N+1; i++) table[i] = new ArrayList<>();
		for(int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			pos[i][0] = x;
			pos[i][1] = y;
		}
		
		for(int i = 1; i < N; i++) {
			for(int j = i+1; j < N+1; j++) {
				double xPow = Math.pow(pos[i][0] - pos[j][0], 2);
				double yPow = Math.pow(pos[i][1] - pos[j][1], 2);
				double dis = dist(xPow,yPow);
				table[i].add(new Edge(j,dis));
				table[j].add(new Edge(i,dis));
			}
		}
		prim(1,N);
	}
	static class Edge implements Comparable<Edge>{
		int to;
		double weight;
		public Edge(int to,double weight) {
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if(this.weight > o.weight) return 1;
			else if(o.weight > this.weight) return -1;
			else return 0;
		}
	}
	
	static void prim(int start, int n) {
		boolean[] visited = new boolean[n+1];
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		double res = 0;
		pq.add(new Edge(start,0.0));
		
		while(!pq.isEmpty()) {
			Edge now = pq.poll();
			int to = now.to;
			double weight = now.weight;
			if(visited[to]) continue;
			visited[to] = true;
			res += weight;
			for(Edge next : table[to]) {
				pq.add(next);
			}
		}
		System.out.printf("%.2f",res);
	}
	
	static double dist(double x, double y) {
		return Math.sqrt(x+y);
	}
}
