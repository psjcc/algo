import java.io.*;
import java.util.*;

public class BOJ_2468_안전영역 {
	static int n;
	static int[][] g;
	static boolean[][] visit;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		visit = new boolean[n][n];
		g = new int[n][n];
		for (int i=0; i<n; i++) {
			String[] st =br.readLine().split(" ");
			for (int j=0; j<n; j++) {
				g[i][j] = Integer.parseInt(st[j]);
			}
		}
		int ans = 1;
		for (int i=1; i<101; i++) {
			ans = Math.max(ans, rain(i));
		}
		System.out.println(ans);
	}
	public static void bfs(int i, int j, int h) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {i,j});
		visit[i][j] = true;
		while(!q.isEmpty()) {
			int[] ij = q.poll();
			for (int k=0; k<4; k++) {
				int x=ij[0]+dx[k], y=ij[1]+dy[k];
				if (x<0 || y<0 || x>=n || y>=n) continue;
				if (!visit[x][y] && g[x][y] > h) {q.add(new int[] {x,y}); visit[x][y]=true;}
			}
		}
	}

	public static int rain(int h) {
		int r=0;
		visinit();
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				if (visit[i][j] || g[i][j] <= h) continue;
				r++;
				bfs(i,j,h);
			}
		}
		return r;
	}
	public static void visinit() {
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				visit[i][j] = false;
			}
		}
	}
}
