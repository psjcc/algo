package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10844_쉬운계단수 {
	static int[][] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N+1][10];
		
		Arrays.fill(dp[1], 1);
		dp[1][0] = 0;
		for(int i = 2; i < N+1; i++) {
//			System.out.println(11111);
			for(int j = 0; j < 10; j++) {
				if(j == 0) dp[i][j+1] += dp[i-1][j]%1000000000; 
				else if( j == 9) dp[i][j-1] += dp[i-1][j]%1000000000;
				else {
					dp[i][j+1] += dp[i-1][j]%1000000000;
					dp[i][j-1] += dp[i-1][j]%1000000000;
				}
			}
		}
		long result = 0;
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		System.out.println(result%1000000000);
	}

}
