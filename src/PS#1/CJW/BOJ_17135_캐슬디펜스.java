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
		} // 입력 완
		
		maxa = Math.min(maxa, n*3); // 게임이 n 턴 진행되고 궁수는 3명이므로 
		//maxa: 최대 사냥 가능 적 저장
		int ans=0;
		l:for (int i=0; i<m-2; i++) { // 궁수 3명의 위치 for문으로 완탐 ^^
			for (int j=i+1; j<m-1; j++) {
				for (int k=j+1; k<m; k++) {
					initmap(mapc); // 지도 초기화
					ans = Math.max(ans, turn(i,j,k)); //"ans" 에 최댓값 저장
					if (ans==maxa) break l; // 최대로 사냥 성공하면 그만
				}
			}
		}
		System.out.println(ans);
	}
	static void initmap(int[][] c) { // 2중배열 복사하는 함수
		for (int i=0; i<n; i++) map[i] = c[i].clone(); 
	}
	static int turn(int i, int j, int k) { // n턴만큼 게임 진행하고 최대 사냥 수 return
		int ans=0;
		int[] deli;
		int[] delj;
		int[] delk;
		for (int c=n-1; c>=0; c--) {
			deli = bfs(c, i); 
			delj = bfs(c, j);
			delk = bfs(c, k);
			if (deli[0]!=-1) {ans++; map[deli[0]][deli[1]] = 0;} // 적을 못찾았거나 다른 궁수가 저격중이면 pass
			if (delj[0]!=-1 && neq(deli, delj)) {ans ++; map[delj[0]][delj[1]] = 0;} 
			if (delk[0]!=-1 && neq(deli, delk) && neq(delj, delk)) {ans++; map[delk[0]][delk[1]]=0;}
		}
		return ans;
	}
	static boolean neq(int[] x, int[] y) { // 두 점이 다른 점을 가르키는지 확인
		if (x[0]==y[0] && x[1]==y[1]) return false;
		return true;
	}
	static int[] bfs(int r, int c) { // 최단거리의 적을 bfs로 찾아냅니다.
		if (map[r][c]==1) return new int[] {r,c,1}; //궁수 바로 앞자리부터 탐색 시작
		Deque<int[]> q = new ArrayDeque<>();
		q.add(new int[] {r,c,1}); // r: y좌표 c: x좌표 d: 궁수와의 거리 
		boolean visit[][] = new boolean[n][m];
		visit[r][c] = true;
		int[] now; 
		int nr, nc, nd;
		while (!q.isEmpty()) {
			now = q.pop(); // now 현재 탐색 노드 정보
			if (now[2]==d) break; // 거리가 d라면 d+1부터는 탐색 필요없음
			nd = now[2]+1; // nd : 다음 탐색위치와 궁수 사이 사거리
			for (int k=0; k<3; k++) {
				nr = now[0] + dr[k]; nc = now[1] + dc[k]; // nr: next r, nc: next c
				if (nr<0 || nc<0 || m<=nc || visit[nr][nc]) continue; // 탐색범위 밖이거나, 방문 했으면 continue;
				if (map[nr][nc]==1) return new int[] {nr, nc, nd}; // 적을 찾으면 바로 return
				
				q.add(new int[] {nr, nc, nd});
				visit[nr][nc] = true; // q에 넣고 방문 처리
			}
		}
		return new int[] {-1,-1,-1}; // 못찾으면 -1 return
	}
}
