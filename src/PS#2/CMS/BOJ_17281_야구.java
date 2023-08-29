package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17281_야구 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, answer;
	static int[][] info;
	static boolean[] selected = new boolean[9];
	static int[] result = new int[9];
	
	
	
	
	public static int playBall() {
		int score = 0;
		int inning = 0;
//		1번 타자부터 시작
		int cnt = 0; 
		
		Deque<Integer> base = new ArrayDeque<Integer>();

		
		while(true) {
			if(inning == N) break;
//			이닝 시작
			int out = 0;
			base.clear();
			for(int i = 0; i < 3; i++) {
				base.offer(0);
			}
			while(out < 3) {
				switch (info[inning][result[cnt]]) {
				case 0:
					out += 1;
					break;
				case 1:
					base.offer(1);
					if(base.poll() == 1) score += 1;
					break;
				case 2:
					base.offer(1);
					if(base.poll() == 1) score += 1;
					base.offer(0);
					if(base.poll() == 1) score += 1;
					break;
				case 3:
					base.offer(1);
					if(base.poll() == 1) score += 1;
					base.offer(0);
					if(base.poll() == 1) score += 1;
					base.offer(0);
					if(base.poll() == 1) score += 1;
					break;
				case 4:
					score += 1;
					for(int i = 0; i < 3; i++) {
						base.offer(0);
						if(base.poll() == 1) score += 1;
					}
					break;
	
				}
				cnt = (cnt + 1) % 9;
			}
			
			inning += 1;
		}
		return score;
	}
	
	
	public static void perm(int tdx) {
		if(tdx == 3) tdx += 1;
		if(tdx == 9) {
//			System.out.println(Arrays.toString(result));
			int score = playBall();
			answer = Math.max(answer, score);
			return;
		}
		
		for(int i = 0; i < 9; i++) {
			if(selected[i]) continue;
			
			result[tdx] = i;
			selected[i] = true;
			perm(tdx + 1);
			selected[i] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		info = new int[N][9];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		selected[0] = true;
		result[3] = 0;
		answer = 0;
		
		perm(0);
		
		System.out.println(answer);


	}

}
