package swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		int[][] table = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			table[i][0] = Integer.parseInt(st.nextToken());
			table[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(table,(o1,o2) ->{return o1 == o2? o1[0] - o2[0] : o1[1] - o2[1];});
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 2; j++) {
				bw.write(String.valueOf(table[i][j] + " "));
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
	
}