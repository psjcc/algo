import java.io.*;
import java.util.*;
public class BOJ_1535_hi {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] hp = new int[n]; int[] pp = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) hp[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) pp[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[100];
		for (int j=99; j>=0; j--) dp[j] = j<hp[0]? 0:pp[0];
		for (int i=1; i<n-1; i++) {
			for (int j=99; j>=hp[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j-hp[i]] + pp[i]);
			}
		}
		System.out.println(hp[n-1]<=99? Math.max(dp[99], dp[99-hp[n-1]]+pp[n-1]):dp[99]);
	}

}
