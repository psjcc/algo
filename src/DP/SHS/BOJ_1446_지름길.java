package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1446_지름길 {
	static int[] dp;
	static int dest,N;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		dest = Integer.parseInt(st.nextToken());

		dp = new int[dest+1];
		for(int i = 0; i < dest+1; i++) {
			dp[i] = i;
		}
		Edge[] shortcut = new Edge[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int from  = Integer.parseInt(st.nextToken());
			int to  = Integer.parseInt(st.nextToken());
			int weight  = Integer.parseInt(st.nextToken());
			if(to - from < weight) to = -1;
			shortcut[i] = new Edge(from,to,weight);
		}
		
		Arrays.sort(shortcut);
		for(int i=0; i < N; i++)
			run(shortcut[i]);
		System.out.println(dp[dest]);
			
	}
	static class Edge implements Comparable<Edge>{
		int from,to, weight;
		
		public Edge(int from,int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.from - o.from;
		}
		
		
	}
	
	static int run(Edge edge) {
		if(edge.to > dest || edge.to == -1) return 0;
		
		if(dp[edge.from] + edge.weight < dp[edge.to]) {
			dp[edge.to] = dp[edge.from] + edge.weight;
			for(int i = 1; edge.to + i <= dest; i++) {
				if(dp[edge.to] + i < dp[edge.to+i]) {
					dp[edge.to+i] = dp[edge.to] + i;
				}
			}
		}
		return dp[edge.to];
	}
}
