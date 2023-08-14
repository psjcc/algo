package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class SWEA_1228_암호문1 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int T = 10;
	public static void main(String[] args) throws Exception{
		
		for(int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int C = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = 0;
			while(cnt < C) {
				st.nextToken();
				int s = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				for(int i = 0; i < n; i++) {
					list.add(s + i, Integer.parseInt(st.nextToken()));
				}
				cnt += 1;
			}
			
			for(int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);

	}

}
