package backj;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Bj_2468 {
	static boolean[][] visited;
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] table = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j< N; j++) {
				table[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < 101; i++) {
			visited = new boolean[N][N];
			int n = table_col(i,table,N);
			if(n > max) {
				max = n;
			}
			else if(n == 0) break;
		}
		System.out.println(max);
	}
	
	public static int table_col(int height, int[][] table, int n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(table[i][j] > height) {
					visited[i][j] = true;
				}
			}
		}
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(visited[i][j]) {
					cnt+=bfs(j,i,n);
				}
			}
		}
		return cnt;
	}
	
	public static int bfs(int x,int y,int length) {
		Deque<int[]> q = new ArrayDeque<>();
		int[] arr = {x,y};
		visited[y][x] = false;
		q.add(arr);
		while(!q.isEmpty()) {
			int[] now = q.poll();
			for(int i = 0; i < 4; i++) {
				x = now[0] + dx[i];
				y = now[1] + dy[i];
				if(0<=x && x < length && 0<=y && y < length) {
					if(visited[y][x]) {
						int[] arr2 = {x,y};
						q.add(arr2);
						visited[y][x] = false;
					}
				}
			}
		}
		return 1;
	}
}