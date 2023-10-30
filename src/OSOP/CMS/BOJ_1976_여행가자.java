package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1976_여행가자 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[][] adj;
	static final int INF = 10000000;
	
	
	public static void f() {
		for(int k = 0; k < N; k++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		

		adj = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
				if(adj[i][j] == 0) adj[i][j] = INF;
			}
		}
		if(M == 0 || N == 1) {
			System.out.println("YES");
			return;
		}

		f();
		
		
		
		st = new StringTokenizer(br.readLine());
		int cur = Integer.parseInt(st.nextToken());
		for(int i = 1; i < M; i++) {
			int next = Integer.parseInt(st.nextToken());
			if(adj[cur - 1][next - 1] == INF) {
				System.out.println("NO");
				return;
			}
			cur = next;
		}
		
		
		System.out.println("YES");
		
		
		
		

	}

}