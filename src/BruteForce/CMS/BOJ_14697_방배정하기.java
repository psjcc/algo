package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14697_방배정하기 {
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] room = new int[3];
		
		for(int i = 0; i < 3; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}
		N = Integer.parseInt(st.nextToken());
		int max = N / room[0] + 1;
		boolean flag = false;
		for(int i = 0; i < max; i++) {
			for(int j = 0; j < max; j++) {
				for(int k = 0; k < max; k++) {
					int total = room[0] * i + room[1] * j + room[2] * k;
					if(total == N) {
						flag = true;
					}
				}
				if(flag) break;
			}
			if(flag) break;
		}
		
		int answer = flag ? 1 : 0;
		System.out.println(answer);

	}

}
