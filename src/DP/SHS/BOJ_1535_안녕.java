package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1535_안녕 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int life = 99;
		
		int[] scr = new int[N+1];
		int[] drain = new int[N+1];
		int[][] dp  = new int[N+1][life+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N+1; i++) {
			drain[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i < N+1; i++) {
			scr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < life+1; j++) {
				if(drain[i] <= j)
					dp[i][j] = Math.max(dp[i-1][j-drain[i]]+scr[i], dp[i-1][j]);
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		
		System.out.println(dp[N][99]);
	}

}
