package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17404_RGB거리2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[][] house;
	static int[][] dp;
	static int N;
	static final int INF =1001;
	static int answer = INF;
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		
		house = new int[N][3];
		dp = new int[N][3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			house[i][0] = Integer.parseInt(st.nextToken());
			house[i][1] = Integer.parseInt(st.nextToken());
			house[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int k = 0; k < 3; k++) {
			for(int i = 0; i < 3; i++) {
				if(i == k) dp[0][i] =  house[0][i];
				else dp[0][i] = INF;
			}
			
			for(int i = 1; i < N; i++) {
				dp[i][0] = house[i][0] + Math.min(dp[i - 1][1], dp[i-1][2]);
				dp[i][1] = house[i][1] + Math.min(dp[i - 1][0], dp[i-1][2]);
				dp[i][2] = house[i][2] + Math.min(dp[i - 1][0], dp[i-1][1]);
			}
			
			
			for(int i = 0; i < 3; i++) {
				if(i != k) answer = Math.min(answer, dp[N-1][i]);
			}

		}
		
		System.out.println(answer);


	}

}
