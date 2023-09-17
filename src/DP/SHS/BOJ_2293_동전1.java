package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2293_동전1 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] dp = new int[10001];
		
		int[] coins = new int[100];
		
		for(int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			int now = coins[i];
			if(now <= K)
				dp[now]++;
			for(int j = now+1; j <= K; j++) {
				dp[j] += dp[j-now];
			}
		}
		System.out.println(dp[K]);
	}

}
