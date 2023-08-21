package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17135_캐슬디펜스 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, D, answer;
	static int tmpKill;
	static int[][] map;
	static int[] archer;
	
	
	public static void kill(int archer, int time, int[][] map) {
		int curRow = N - time;
		int curCol = archer;
		int targetRow = -1;
		int targetCol = -1;
		int minD = Integer.MAX_VALUE;
		
		for(int j = 0; j < M; j++) {
			for(int i = 0; i < N - time; i++) {
				if(map[i][j] == 0) continue;
				int d = Math.abs(curRow - i) + Math.abs(curCol - j);
				if(d > D) continue;
				
				if(minD > d) {
					minD = d;
					targetRow = i;
					targetCol = j;
				}
			}
		}
		
		if(targetRow != -1 && targetCol != -1) {
			if(map[targetRow][targetCol] == 1) {
				tmpKill += 1;
				map[targetRow][targetCol] = -1;
			}
			
		}
		
	}
	
	
	public static void comb(int idx, int tdx) {
		if(tdx == 3) {
// 위로 올라가면서 하나씩 죽여야함
			int[][] newMap = new int[N][];
//			System.out.println("==========================");
//			System.out.println(Arrays.toString(archer));
			for(int i = 0; i < N; i++) {
				newMap[i] = Arrays.copyOf(map[i], M);
			}
			
			
			tmpKill = 0;
			for(int t = 0; t < N; t++) {
//				System.out.println("TIME : " + t);
				for(int i = 0; i < 3; i++) {
					int cur = archer[i];
					kill(cur, t, newMap);
				}
				
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						if(newMap[i][j] == -1) newMap[i][j] = 0;
						
						
					}
//					System.out.println(Arrays.toString(newMap[i]));
				}
			}
			
//			System.out.println("Kill : " + tmpKill);
			if(answer < tmpKill) answer = tmpKill;
			
			return;
		}
		if(idx == M) return;
		
		archer[tdx] = idx;
		comb(idx + 1, tdx + 1);
		comb(idx + 1, tdx);
	}
	
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		answer = 0;
		
		map = new int[N + 1][M];
		archer = new int[3];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		comb(0, 0);
		System.out.println(answer);
	}
}
