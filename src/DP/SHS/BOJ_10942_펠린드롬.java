package backj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10942_펠린드롬 {
	static int[][] dp;
	static int[] arr;
	static int N, INF= 100000000;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp = new int[N+1][N+1];
		arr = new int[N+1];
		
		for(int i = 1; i < N+1; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		for(int i = 1; i < N+1; i++) Arrays.fill(dp[i], INF);
		for(int i = 1; i < N; i++) {
			dp[i][i] = 1;
			
			if(arr[i] == arr[i+1]) {
				dp[i][i+1] = 1;
			}
		}
		dp[N][N] = 1;
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			bw.write(pel(S,E) + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	static int pel(int S, int E) {
		if(dp[S][E] != INF) return dp[S][E];
		
		if(arr[S] == arr[E] && pel(S+1,E-1) == 1) return dp[S][E] = 1;
		return dp[S][E] = 0;
	}

}
