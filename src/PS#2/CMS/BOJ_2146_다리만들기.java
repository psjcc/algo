package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2146_다리만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int answer = Integer.MAX_VALUE;
	
	
	
	static class Node{
		int row;
		int col;
		int len;
		Node(int row, int col){
			this.row = row;
			this.col = col;
		}
		Node(int row, int col, int len){
			this.row = row;
			this.col = col;
			this.len = len;
		}
	}
	public static void bfs(Node start, int num) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(start);
		map[start.row][start.col] = num;
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int row = cur.row;
			int col = cur.col;
			
			for(int d = 0; d < 4; d++) {
				int nr = row + dy[d];
				int nc = col + dx[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(map[nr][nc] != 1) continue;
				map[nr][nc] = num;
				queue.offer(new Node(nr, nc));
			}
		}
	}
	
	public static void search(Node start, int num, int[][] map) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(start);
		map[start.row][start.col] = -1;
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();
			int row = cur.row;
			int col = cur.col;
			int length = cur.len;
			
			for(int d = 0; d < 4; d++) {
				int nr = row + dy[d];
				int nc = col + dx[d];
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
				if(map[nr][nc] == num) continue;
				if(map[nr][nc] > 0) {
					answer = Math.min(answer, length);
				}
				if(map[nr][nc] == 0 ) {
					map[nr][nc] = -1;
					queue.offer(new Node(nr, nc, length + 1));
				}

			}
		}
	}
	
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		Queue<Node> queue = new LinkedList<>();
		
	
		
		map = new int[N][N];
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				int e = Integer.parseInt(st.nextToken());
				map[i][j] = e;
				if(e == 1) queue.offer(new Node(i, j));
			}
		}
		
		int num = 2;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					bfs(new Node(i, j), num);
					num += 1;
				}
			}
		}
		
//		for(int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		
		
		while(!queue.isEmpty()) {
			int[][] newMap = new int[N][];
			for(int i = 0; i < N; i++) {
				newMap[i] = map[i].clone();
			}

			Node cur = queue.poll();
			
			search(cur, map[cur.row][cur.col], newMap);
		}
		

		
		System.out.println(answer);
		
		
		
		
		
		
	}

}
