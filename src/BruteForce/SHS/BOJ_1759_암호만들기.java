package backj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj_1759 {
	static char[] result;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		result = new char[N];
		char[] arr = new char[C];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		combination(0,0,arr,N,C,0,0);
		bw.flush();
		bw.close();
		
	}
	static void combination(int cnt, int idx,char[] arr,int N, int C, int ga, int con) throws IOException {
		if(cnt == N) {
			if(ga >= 1 && con >= 2) {
				for(int i = 0; i < N; i++) {
					bw.write(result[i]);
				}
				bw.write(" " + ga + " " + con);
				bw.write("\n");
			}
			return;
		}
		for(int i = idx; i < C; i++) {
			result[cnt] = arr[i];
			if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' ||arr[i] == 'o' || arr[i] == 'u')
				combination(cnt+1,i+1,arr,N,C,ga+1,con);
			else
				combination(cnt+1,i+1,arr,N,C,ga,con+1);
		}
	}
}
