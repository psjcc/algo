import java.util.*;
import java.io.*;

public class BOJ_10942_팰린드롬 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[][] dp;
	static int[] arr;
	
	public static void main(String[] arg) throws IOException {
		int n = Integer.parseInt(br.readLine());
		arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
		dp = new int[n][n];
		for (int len=0; len<n; len++) {
			for (int i=0; i+len<n;i++) {
				 ispalin(i,i+len);
			}
		}
		int m = Integer.parseInt(br.readLine());
		int s, e;
        StringBuilder sb = new StringBuilder();
		for (int i=0; i<m;i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			sb.append(dp[s-1][e-1]).append("\n");
		}
		System.out.println(sb);
		
		
	} // main
	
	public static void ispalin(int i, int j) {
		if (i==j) dp[i][j]=1;
		else if ((i==j-1) && (arr[i] == arr[j])) dp[i][j]= 1;
		else if ((arr[i] == arr[j]) && dp[i+1][j-1]==1) dp[i][j]= 1;
		else dp[i][j]=0;
	}
}