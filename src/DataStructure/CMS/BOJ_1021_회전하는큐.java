package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ_1021_회전하는큐 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int answer = 0;
	static int N, M;
	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Deque<Integer> queue = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		
		int[] list = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		int cnt = 0;
		Iterator<Integer> iter = queue.iterator();
		while(cnt < M) {

			int idx = 0;
			for(Integer item : queue) {
				if(list[cnt] == item) break;
				idx += 1;
			}
			
			int fromLeft = idx;
			int fromRight = queue.size() - idx; 
//			System.out.printf("%d %d\n", fromLeft, fromRight);
			if(fromLeft <= fromRight) {
				for(int i = 0; i < fromLeft; i++) {
					queue.offerLast(queue.pollFirst());
					answer += 1;
				}
			}
			else {
				for(int i = 0; i < fromRight; i++) {
					queue.offerFirst(queue.pollLast());
					answer += 1;
				}
			}
			
			if(queue.getFirst() == list[cnt]) {
				queue.pollFirst();
				cnt += 1;	
			}

		}
		System.out.println(answer);
		
		
		
		
		
	}

}
