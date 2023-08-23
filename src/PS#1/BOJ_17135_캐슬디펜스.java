package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
	static int N, M, range, ans;
	static int[] castle = new int[3];
	static int[][] table;
	static boolean[][] visited;
	static int[] dx = {-1,0,1};
	static int[] dy = {0,1,0};
 	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st  = new StringTokenizer(br.readLine());
		ans = Integer.MIN_VALUE ;
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		range = Integer.parseInt(st.nextToken());
		
		table = new int[N][M];
		
		comb(new boolean[N], M,3,0);
		
		System.out.println(ans);
	}
	static void comb(boolean[] temp,int n,int r, int depth) {
		if(r == 0) {
			int k = 0;
			for(int i = 0; i < n; i++)
				if(temp[i]) castle[k++] = i;
			int q = attack();
			if(q > ans)
				ans = q;
			return;
		}
		if(depth == n) return;
		
		temp[depth] = true;
		comb(temp,n,r-1,depth+1);
		temp[depth] = false;
		comb(temp,n,r,depth+1);
	}
	
	static int attack() {
		int temp = 0;
		int[][] check = new int[3][2];
		for(int j = 0; j < N; j++) {
			for(int i = 0; i < 3; i++) {
				int[] arr = search(castle[i], -1+j, range, new boolean[N][M]);
				if(arr != null) {
					check[i][0] = arr[0]; 
					check[i][1] = arr[1]; 
				}
			}
			for(int i = 0; i < 3; i++) {
				if(table[check[i][0]][table[i][1]] == 1) {
					table[check[i][0]][table[i][1]] = 0;
					temp++;
				}
			}
		}
		return temp;
	}
	static int[] search(int x, int y, int range, boolean[][] visited) {
		int now = 1;
		Deque<int[]> q = new ArrayDeque<>();
		
		q.add(new int[] {y+1,x});
		visited[y+1][x] = true;
		while(!q.isEmpty() || !(now > range)) {
			now++;
			int[] temp = q.poll();
			if(table[temp[0]][temp[1]] == 0) {
				int xx = 0;
				int yy = 0;
				for(int i = 0; i < 3; i++) {
					xx = temp[1] + dx[i];
					yy = temp[0] + dy[i];
					if(0<= xx && xx < M && 0 <= yy && yy<N)
						q.add(new int[] {yy,xx});
				}
			}
			else {
				return temp;
			}
		}
		return null;
	}
}

