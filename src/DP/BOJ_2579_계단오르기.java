package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2579_계단오르기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N =Integer.parseInt(br.readLine());
		int[] stairs = new int[N+1];
		int[] dp = new int[N+1];
		for(int i = 1; i <= N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		dp[1] = stairs[1];
		if(N>=2) {
			dp[2] = stairs[1] + stairs[2];
			if(N >= 3) {
				int now = 3;
				while(now <= N) {
					
					if(stairs[now-1] + dp[now-3] > dp[now-2]) {
						dp[now] = stairs[now-1]+dp[now-3]+stairs[now];
					}
					else
						dp[now] = dp[now-2]+stairs[now];	
					now++;
				}
			}
		}
		System.out.println(dp[N]);
	}

}
