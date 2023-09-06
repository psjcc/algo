package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_10942_팰린드롬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] nums;
	static boolean[][] dp;

	
	public static void f() {
		dp = new boolean[N+1][N+1];
		for(int i = 1; i <= N; i++) {
			dp[i][i] = true;
		}
		
		for(int i = 1; i <=N - 1; i++) {
			if(nums[i] == nums[i + 1]) dp[i][i + 1] = true;
		}
//		i 는 길이
		for(int i = 2; i <= N; i++) {
			for(int s = 1; s <= N - i; s++) {
				if(nums[s] == nums[s + i] && dp[s+1][s + i - 1]) dp[s][s + i] = true;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		nums = new int[N + 1];
		for(int i = 0; i < N; i++) {
			nums[i + 1] = Integer.parseInt(st.nextToken());
		}
		
		f();
		
		M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			if(dp[S][E]) sb.append("1\n");
			else sb.append("0\n");
		}
		
		System.out.print(sb);
	}

}
