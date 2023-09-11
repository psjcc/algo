import java.io.*;
import java.util.*;
public class BOJ_11055_가큰증부수 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		for (int i=0; i<n-1; i++){
			for (int j=i+1; j<n; j++){
				if (arr[i]<arr[j]) dp[j] = Math.max(dp[j], dp[i]+arr[j]);
			}
		}
		int ans=0;
		for (int i=0; i<n; i++) ans = Math.max(ans, dp[i]);
		
		System.out.println(ans);
	} // main
}