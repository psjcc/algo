package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_14658_별똥별 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, L, K;
	static Star[] star;
	static int answer;
	
	static class Star{
		int x, y;
		Star(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static int f(int x, int y) {
		int cnt = 0;
		
		for(int i = 0; i < K; i++) {
			Star s = star[i];
			if(x <= s.x && s.x <=x + L && y <= s.y && s.y <= y + L) {
				cnt += 1;
			}
			
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L= Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		answer = K;
		
		star = new Star[K];
		
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			star[i] = new Star(x, y);
		}
		
		for(int i = 0; i < K; i++) {
			for(int j = 0; j < K; j++) {
				int result = K - f(star[i].x, star[j].y);
				answer = Math.min(answer, result);
			}
		}
		
		System.out.println(answer);
	}

}
