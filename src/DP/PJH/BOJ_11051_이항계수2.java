package algorithm2023.sep.day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11051_이항계수2 {
	static int N, K, dp[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[N+1][K+1];
		
		for(int i =0;i<=N;i++) {
			dp[i][i] = 1;
			dp[i][1] = i;
		}
		System.out.println(bino_coef(N,K));
		
	}
	
	static int bino_coef(int n, int k) {
		if(k>n)return 0;
		if(n==k||k==0) return 1;
		if(dp[n][k]>0)return dp[n][k];
		
		return dp[n][k] = (bino_coef(n-1,k)+bino_coef(n-1,k-1))%10007;
	}
	
}
