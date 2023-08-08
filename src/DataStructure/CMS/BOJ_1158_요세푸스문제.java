package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_1158_요세푸스문제 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, K;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Deque<Integer> queue = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		sb.append("<");
		while(!queue.isEmpty()) {
		
			for(int i = 0; i < K - 1; i ++) {
				queue.offer(queue.pollFirst());
			}
			sb.append(queue.pollFirst()).append(", ");
		}
		int d =sb.lastIndexOf(", ");
		sb.delete(d, d + 2);
		sb.append(">");

		System.out.println(sb);
		
		


		
		
		
		
		
	}

}
