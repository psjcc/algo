package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Bj_2493 {
	static int N;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		boolean table[][] = new boolean[N][N];
		
		for(int i = 0; i < M; i++) {
			st= new StringTokenizer(br.readLine());
			int A =Integer.parseInt(st.nextToken())-1;
			int B = Integer.parseInt(st.nextToken())-1;
			table[A][B] = true;
			table[B][A] = true;
		}
		
		System.out.println(bfs(0,0,table));
	}
	public static int bfs(int start_x, int start_y,boolean[][] table) {
		boolean[][] visited = new boolean[N][N];
		visited[start_y][start_x] = true;
		Deque<boolean[]> dq = new ArrayDeque<>();
		dq.add(table[start_y]);
		int cnt = 0;
		while(!dq.isEmpty()) {
			boolean[] now = dq.poll();
			for(int i = 0; i < N; i++) {
				if(now[i] && !visited[start_y][i]) {
					dq.add(table[i]);
					cnt++;
					visited[start_y][i] = true;
				}
			}
		}
		return cnt;
		
	}
}
