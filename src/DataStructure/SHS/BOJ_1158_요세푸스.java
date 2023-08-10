package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Bj_1158 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		Deque<Integer> cir = new ArrayDeque<>();
		int[] ans = new int[N];
		for(int i = 0; i < N; i++)
			cir.add(i+1);
		for(int i = 0; i < N; i++) {
			for(int j = 0; j <K-1; j++) {
				cir.add(cir.pop());
			}
			ans[i] = cir.pop();
		}
		
		bw.write("<");
		for(int i = 0; i < N-1; i++) {
			bw.write(ans[i] + ", ");
		}
		bw.write(ans[N-1] + ">");
		
		bw.flush();
		bw.close();
	}

}
