package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {
	static int N, ans;
	static int[][] score;
	static boolean[] grd;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		score = new int[N][9];
		grd = new boolean[9];
		ans = Integer.MIN_VALUE;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] player = {2,3,4,5,6,7,8,9};
		
		Permutation(player, new int[8], 8, 0, new boolean[9]);
		
		System.out.println(ans);
	}
	
	static void Permutation(int[] arr, int[] output,  int n, int r, boolean[] visited)  {
		if(r == 8) {
			int[] lineup = new int[9];
			lineup[3] = 1;
			int k = 0;
			for(int i = 0; i < 9; i++) {
				if(i == 3) continue;
				lineup[i] = output[k];
				k++;
			}
			ans = Math.max(ans,letsplay(lineup));
			
			return;
		}
		
		for(int i = 0; i < 8; i++) {
			if(!visited[i]) {
				visited[i] = true;
				output[r] = arr[i];
				Permutation(arr, output, n, r+1 , visited);
				visited[i] = false;
			}
		}
	}