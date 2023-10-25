package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;


public class BOJ_1976_여행가자 {
	static boolean[][] graph;
	static int[] parent;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		boolean visited[][] = new boolean[N][N]; 
		parent = new int[N];
		for(int i = 0; i<N; i++)
			parent[i] = i;
		graph = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int x = Integer.parseInt(st.nextToken());
				if(x == 1 ) {
					union(i,j);
					visited[i][j] = true;
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int temp = parent[Integer.parseInt(st.nextToken())-1];
		boolean result = true;
		for(int i = 0; i < M-1; i++) {
			if(temp != parent[Integer.parseInt(st.nextToken())-1]) {
                result = false;
                break;
            }
		}
		if(result) System.out.println("YES");
		else System.out.println("NO");
	}
	public static int find(int x) {
		if(parent[x] == x) return x;
		return find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		if(x == y) return;
		if(x >= y) parent[x] = y;
		else parent[y] = x;
	}
}
