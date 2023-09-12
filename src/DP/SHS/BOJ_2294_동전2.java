package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2294_동전2 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int INF = 100000000;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		Arrays.sort(coins);
		int[] dp = new int[K+1];
		Arrays.fill(dp, INF);
		for(int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
			if(coins[i] < K)
				dp[coins[i]] = 1;
		}
		
		for(int i = 1; i <= K; i++) {
			
			for(int j = 0; j < N; j++) {
                if(coins[j] > K) break;
				int now = i;
				if(now % coins[j] ==0 && (dp[i] > now/coins[j]))
					dp[i] = now / coins[j];
			}
			for(int j = 0; j < N; j++) {
				if(i-coins[j] > 0 && dp[i-coins[j]] != 0 && (dp[i] > dp[i-coins[j]] + 1))
					dp[i] = dp[i-coins[j]]+1;
			}
		}
		if(dp[K] == INF) dp[K] = -1;
		System.out.println(dp[K]);
	}

}