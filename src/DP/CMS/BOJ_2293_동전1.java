package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2293_동전1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	static int[] coin;
	static int[] dp;

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coin = new int[K + 1];
		dp = new int[K + 1];
		dp[0] = 1;
		for(int i = 1; i <= N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
			for(int k = coin[i]; k <= K; k++) {
				dp[k] += dp[k - coin[i]];
			}
		}
		
		
		
		System.out.println(dp[K]);
		
		
		
		
		

	}

}
