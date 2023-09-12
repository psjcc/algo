package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기 {
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		dp = new int[11];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i = 0 ; i < testcase; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(calc(n));
		}
	}
	static int calc(int n) {
		if(dp[n] != 0) return dp[n];
		return dp[n] = calc(n-1)+calc(n-2)+calc(n-3);
	}
}
