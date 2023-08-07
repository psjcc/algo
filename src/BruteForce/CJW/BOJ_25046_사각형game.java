import java.io.*;
import java.util.Arrays;
public class BOJ_25046_사각형game {
	static long[][] g;
	static boolean[] select;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		g = new long[n+1][n+1];
		select = new boolean[n];
		for (int i=0; i<n; i++) {g[i][n] = 0; g[n][i] =0;} 
		for (int i=0; i<n; i++) {
			String[] st = br.readLine().split(" ");
			for (int j=0; j<n; j++) {
				g[i][j] = Integer.parseInt(st[j]);
				g[i][n] += g[i][j]; g[n][i] += g[i][j];
			}
		}
		long ans = 0;
		for (int i=0; i < 1<<n; i++) {
			for (int s=0; s<n; s++) {
				if (( i | (1<<s) ) == i) select[s] = true;
				else select[s] = false;
			}
			long t = minwoo(); System.out.println(Integer.toBinaryString(i)+" "+Arrays.toString(select)+" "+t+" ");
			if (ans < t) {ans=t; }
		}
		System.out.println(ans);
	} // main
	public static long minwoo() {
		long score = 0;
		for (int i=0;i<n;i++) if (select[i]) score += g[i][n];
		System.out.print(score+" ");
		score -= jongjin();
		System.out.print(score+" ");
		return score;
	}
	
	public static long jongjin() {
		long score = -Integer.MAX_VALUE;
		for (int i=0; i < 1<<n; i++) {
			long temp = 0;
			for (int s=0; s<n; s++) {
				if (( i | (1<<s) ) == i) {
					temp -= g[n][s];
					for (int m=0; m<n; m++) if (select[m]) temp += 2*g[m][s];
				}
			}
			if (score<temp) {score=temp; }
		}
		return score;
	}
}
