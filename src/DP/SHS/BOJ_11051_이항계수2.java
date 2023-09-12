package backj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11051_이항계수2 {
	static int dp[][];
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		dp = new int[N+1][N+1];
		
		System.out.println(comb(N,K));
	}
	
	public static int comb(int N, int k) {
		
		if(k == 0 || k == N) {
			return dp[N][k] = 1;
		}
		
		if(dp[N][k] == 0)
			dp[N][k] = (comb(N-1,k-1) + comb(N-1,k))%10007;
		
		
		return dp[N][k];
	}
}