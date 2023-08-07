package backj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj_1926 {
	static int[] dx = {0,0,-1,1};
	static int[] dy = {-1,1,0,0};
	static boolean[][] visited;
	static boolean end = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int col = Integer.parseInt(st.nextToken());
		int arr = Integer.parseInt(st.nextToken());
		visited = new boolean[col][arr];
		int table[][] = new int[col][arr];
		
		for(int i = 0; i < col; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < arr; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int width = 0;
		int max = 0;
		Loop:
		for(int i = 0; i< col; i++) {
			for(int j = 0; j < arr; j++) {
				if(!visited[i][j] && table[i][j] == 1) {
					cnt++;
					width = bfs(j,i,table);
					if(width > max) {
						max = width;
					}
					if(end) break Loop;
				}
			}
		}
		bw.write(cnt + "\n" + max);
		bw.flush();
		bw.close();
	}
	public static int bfs(int x, int y, int[][] table) {
		Queue<int[]> q = new LinkedList<>();
		int[] loca = {x,y};
		q.add(loca);
		visited[y][x] = true;
		int width = 1;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				x = now[0] + dx[i];
				y = now[1] + dy[i];
				
				if(0<=x && x < visited[i].length &&0<= y && y < visited.length) {
					if(table[y][x] == 1 && !visited[y][x]) {
						int arr2[] = {x,y};
						q.add(arr2);
						visited[y][x] = true;
						width++;
					}
				}
			}
		}
		return width;
	}
}
