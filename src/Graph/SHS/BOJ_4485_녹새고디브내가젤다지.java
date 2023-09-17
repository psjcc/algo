package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4485_녹새고디브내가젤다지 {
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,1,0,-1};
	static ArrayList<ArrayList<Edge>> table;
	static int[][] map,ans;
	static boolean[][] visited;
	static int N = -1;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		table = new ArrayList<>();
		int testcase = 1;
		N = Integer.parseInt(br.readLine());
		while(N != 0) {
			ans = new int[N][N];
			for(int i = 0; i < N; i++)
				Arrays.fill(ans[i], 98765400);
			visited = new boolean[N][N];
			map = new int[N][N];
			for(int i = 0;  i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			PriorityQueue<Edge> pq = new PriorityQueue<>();
			pq.add(new Edge(0,0,map[0][0]));
			visited[0][0] = true;
			ans[0][0] = map[0][0];
			while(!pq.isEmpty()) {
				Edge now = pq.poll();
				
				int x = now.x;
				int y = now.y;
				int weight = now.weight;
				
				
				for(int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					
					if(isin(nx,ny) && !visited[ny][nx] && ans[ny][nx] > (map[ny][nx] + weight)) {
						ans[ny][nx] = map[ny][nx] + weight;
						visited[ny][nx] = true;
						pq.add(new Edge(nx,ny,ans[ny][nx]));
//						System.out.println(ny+ " " + nx + " " + ans[ny][nx]);
					}
				}
			}
			System.out.println("Problem " + testcase +": " +ans[N-1][N-1]);
			N = Integer.parseInt(br.readLine());
			testcase++;
		}
	}
	static boolean isin(int x, int y) {
		if(0 <= x && x < N && 0<=y && y < N) return true;
		return false;
	}
	
	static class Edge implements Comparable<Edge>{
		int x, y;
		int weight;
		
		public Edge(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
}
