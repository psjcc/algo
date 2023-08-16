package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int N;
	static int[][] graph;
	static int[] pArr;
	static int answer = Integer.MAX_VALUE;
	
	public static boolean bfs(int start, ArrayList<Integer> list) {
		
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> visited = new ArrayList<>();
		queue.offer(start);
		visited.add(start);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int d = 1; d <= N; d++ ) {
				if(graph[cur][d] == 0) continue;
				if(visited.contains(d)) continue;
				if(!list.contains(d)) continue;
				queue.offer(d);
				visited.add(d);
			}
		}
		
		if(visited.containsAll(list)) return true;
		return false;
	}
	
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		pArr = new int[N + 1];
		graph = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++ ) {
			pArr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = Integer.parseInt(st.nextToken());
			for(int j = 0; j < cnt; j++) {
				int node = Integer.parseInt(st.nextToken());
				graph[i][node] = 1;
				graph[node][i] = 1;
			}
		}
		
		int size = 1 << N;
//		서브셋으로 모든 경우 확인
//		두개의 리스트로 나눔
//		각각의 리스트를 BFS? 돌려서 연결돼있는지 확인
	
//		공집합은 안되요

		for(int i = 1; i < size - 1; i++) {
			ArrayList<Integer> red = new ArrayList<>();
			ArrayList<Integer> blue = new ArrayList<>();
			for(int j = 0; j < N; j++) {
				if((i & (1 << j)) != 0) {
					red.add(j + 1);
				}
				else {
					blue.add(j + 1);
				}
			}
			
			if( bfs(red.get(0), red) && bfs(blue.get(0), blue)) {
				int redP = 0;
				int blueP = 0;
				for(Integer n : red) {
					
					redP += pArr[n];
				}
				for(Integer n : blue) {
					blueP += pArr[n];
				}
				
				int diff = Math.abs(redP - blueP);
				if(diff < answer) answer = diff;
			}

		}
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
		
		
		
	}
}
