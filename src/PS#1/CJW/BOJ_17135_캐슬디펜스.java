import java.io.*;
import java.util.*;
public class BOJ_17135_캐슬디펜스 {
	static int[][] map;
	static int n, m, d;
	static int[] dr = {0,-1,0};
	static int[] dc = {-1,0,1};
	static int maxa =0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		n = Integer.parseInt(st[0]);
		m = Integer.parseInt(st[1]);
		d = Integer.parseInt(st[2]);
		int[][] mapc = new int[n][m];
		map = new int[n][m];
		for (int i=0; i<n; i++) {
			st = br.readLine().split(" ");
			for (int j=0; j<m; j++) {
				mapc[i][j] = Integer.parseInt(st[j]);
				if (mapc[i][j] == 1) maxa++;
			}
		}
		maxa = Math.min(maxa, n*3);
		int ans=0;
		l:for (int i=0; i<m-2; i++) {
			for (int j=i+1; j<m-1; j++) {
				for (int k=j+1; k<m; k++) {
					initmap(mapc);
					ans = Math.max(ans, turn(i,j,k));
					if (ans==maxa) break l;
				}
			}
		}
		System.out.println(ans);
	}
	static void initmap(int[][] c) {
		for (int i=0; i<n; i++) map[i] = c[i].clone();
	}
	static int turn(int i, int j, int k) {
		int ans=0;
		int[] deli;
		int[] delj;
		int[] delk;
		for (int c=n-1; c>=0; c--) {
			deli = bfs(c, i);
			delj = bfs(c, j);
			delk = bfs(c, k);
			if (deli[0]!=-1) {ans++; map[deli[0]][deli[1]] = 0;}
			if (delj[0]!=-1 && neq(deli, delj)) {ans ++; map[delj[0]][delj[1]] = 0;}
			if (delk[0]!=-1 && neq(deli, delk) && neq(delj, delk)) {ans++; map[delk[0]][delk[1]]=0;}
		}
		return ans;
	}
	static boolean neq(int[] x, int[] y) {
		if (x[0]==y[0] && x[1]==y[1]) return false;
		return true;
	}
	static int[] bfs(int r, int c) {
		if (map[r][c]==1) return new int[] {r,c,1};
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r,c,1});
		boolean visit[][] = new boolean[n][m];
		visit[r][c] = true;
		int[] now;
		int nr, nc, nd;
		while (!q.isEmpty()) {
			now = q.pop();
			if (now[2]==d) break;
			nd = now[2]+1;
			
			for (int k=0; k<3; k++) {
				nr = now[0] + dr[k]; nc = now[1] + dc[k];
				if (nr<0 || nc<0 || m<=nc || visit[nr][nc]) continue;
				if (map[nr][nc]==1) return new int[] {nr, nc, nd};
				
				q.add(new int[] {nr, nc, nd});
				visit[nr][nc] = true;
			}
		}
		return new int[] {-1,-1,-1};
	}
}
