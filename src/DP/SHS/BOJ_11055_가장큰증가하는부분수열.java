package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11055_가장큰증가하는부분수열 {
	static int[] dp,arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new int[N];
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i =0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			dp[i] = num;
		}
		int res = 0;
		for(int i = 0; i < N; i++) {
			int now = calc(i);
			res = Math.max(now, res);
		}
		System.out.println(res);
	}
	static int calc(int idx) {
		for(int i = 1; idx >= i ; i++) {
			if(arr[idx] > arr[idx-i]) {
				if(dp[idx] < dp[idx-i] + arr[idx]) {
					dp[idx] = dp[idx-i] + arr[idx];
				}
			}
		}
		return dp[idx];
	}
}
