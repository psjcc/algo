package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11055_LIS {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] dp1, dp2;
	static int[] arr;
	static int N;
	static int answer = 0;

	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		dp1 = new int[N];
		dp2 = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());	
		}
		
		for(int i = 0; i < N; i++) {
			dp1[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
				}
			}
		}
		
		for(int i = N-1; i >= 0; i--) {
			dp2[i] = 1;
			for(int j = N - 1; j > i; j--) {
				if(arr[j] < arr[i]) {
					dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
				}
			}
		}
//		
//		System.out.println(Arrays.toString(dp1));
//		System.out.println(Arrays.toString(dp2));
//		
		
		for(int i = 0; i < N; i++) {
			answer = Math.max(answer, dp1[i] + dp2[i] - 1);
		}
		
		System.out.println(answer);
	}

}
