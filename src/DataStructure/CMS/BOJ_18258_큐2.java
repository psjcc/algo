package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_18258_큐2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static Deque<Integer> queue = new ArrayDeque<Integer>();
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String command = st.nextToken();
			switch (command) {
			case "push":
				int num = Integer.parseInt(st.nextToken());
				queue.offer(num);
				break;
			case "pop":
				Integer pop= queue.poll();
				sb.append(pop != null ? pop : -1);
				sb.append('\n');
				break;
			case "size":
				sb.append(queue.size());
				sb.append('\n');
				break;
			case "empty":
				sb.append(queue.isEmpty() ? 1 : 0);
				sb.append('\n');
				break;
			case "front":
				sb.append(queue.peekFirst() != null ? queue.peekFirst() : -1);
				sb.append('\n');
				break;
			case "back":
				sb.append(queue.peekLast() != null ? queue.peekLast() : -1);
				sb.append('\n');
				break;
			}
			
		}
		System.out.print(sb);
		
	
	}
}
