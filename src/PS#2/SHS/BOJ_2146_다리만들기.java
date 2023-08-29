package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기 {
	static int[][] map;
	static boolean[][] visited;
	static int N,cnt;
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		cnt = 1;
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1 && !visited[i][j])
					bfs(j,i);
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		int ans = Integer.MAX_VALUE;
		for(int i = 0; i < N; i++) {
			for(int j = 0 ; j < N; j++) {
				if(map[i][j] != 0) { 
					int temp = bridge(j,i,new boolean[N][N]);
					if(temp < ans) ans = temp;
				}
			}
		}
		System.out.println(ans);
		
		
	}
	static void bfs(int x, int y) {
		Deque<int[]> q = new ArrayDeque<>();
		int[] now = {x,y};
		q.add(now);
		visited[y][x] = true;
		map[y][x] = map[y][x] + cnt;
		while(!q.isEmpty()) {
			now = q.poll();
			int xx = now[0];
			int yy = now[1];
			for(int i = 0; i < 4 ; i ++) {
				xx = now[0] + dx[i];
				yy = now[1] + dy[i];
				if(init(xx,yy) && !visited[yy][xx] && map[yy][xx] == 1) {
					q.add(new int[] {xx,yy});
					visited[yy][xx] = true;
					map[yy][xx] += cnt;
				}
			}
		}
		cnt++;
	}
	
	static boolean init(int x, int y) {
		if(x >= N || x < 0|| y < 0 || y >= N) return false;
		return true;
	}
	
	static int bridge(int x, int y, boolean[][] visited) {
		int no = map[y][x];
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x,y});
		int depth = 0;
		while(!q.isEmpty()) {
			int qsize = q.size();
			for(int z = 0; z < qsize; z++) {
				int[] now = q.poll();
				
				int xx = now[0];
				int yy = now[1];
				for(int i = 0; i < 4; i++) {
					xx = now[0] + dx[i];
					yy = now[1] + dy[i];
					if(init(xx,yy) && !visited[yy][xx]) {
						if(map[yy][xx] == 0 ) {
							q.add(new int[] {xx,yy});
							visited[yy][xx] = true;
						}
						else if(map[yy][xx] != no){
//							System.out.println(depth + " " + xx + " " + yy + " " + x + " " + y);
							return depth;
						}
					}
				}
			}
			depth++;
		}
		return Integer.MAX_VALUE;
	}
}