package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14658_하별빛 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] location = new int[K][2];
		
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			location[i][0] = Integer.parseInt(st.nextToken());
			location[i][1] = Integer.parseInt(st.nextToken());
		}
		int res = 0;
		for(int i = 0; i < K; i++) {
			for(int j = 0; j < K; j++) {
				if(Math.abs(location[i][0] - location[j][0]) > L && Math.abs(location[i][1] - location[j][0]) > L) continue;
				int max = 0;
				for(int k = 0; k < K; k++) {
					int x = location[k][0] - location[i][0];
					int y = location[k][1] - location[j][1];
					if(0 <= x && x <= L && 0 <= y && y <=L) max++;
				}
				if(res < max ) res = max;
			}
		}
		
		System.out.println(K-res);
	}

}
