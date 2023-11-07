package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2110_공유기설치 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, C;
	static int[] building;
	
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		building = new int[N];
		
		for(int i = 0; i < N; i++) {
			building[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(building);
		
		System.out.println(bs());
		
	}
	
	public static int install(int d) {
		int cnt = 1;
		int cur = building[0];
		for(int i = 1; i < N; i++) {
			int next = building[i];
			
			if(next - cur < d) continue;
			
			cur = next;
			cnt += 1;
		}
		
		return cnt;
	}
	
	public static int bs() {
		int left = 1;
		int right = building[N-1] - building[0] + 1;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if(install(mid) < C) {
				right = mid;
			}
			else {
				left = mid + 1;
			}
			
		}
		return left - 1;
	}

}
