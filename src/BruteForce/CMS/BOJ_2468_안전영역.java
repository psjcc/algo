package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void bfs(int[][] map, Node start) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(start);
		map[start.y][start.x] = 0;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int x = cur.x;
			int y = cur.y;
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
				if(map[ny][nx] == 0) continue;
				queue.offer(new Node(nx, ny));
				map[ny][nx] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answer = -1;
		
		for(int h = 1; h <= 100; h++) {
			int cnt = 0;
			int[][] newMap = new int[N][N]; 
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(arr[i][j] >= h) {
						newMap[i][j] = 1;
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(newMap[i][j] == 1) {
						bfs(newMap, new Node(j, i));
						cnt += 1;
					}
				}
			}
			
			if(cnt > answer) answer = cnt;
			
			
		}
		
		
		
		
		
		
		System.out.println(answer);
		
	}

}
