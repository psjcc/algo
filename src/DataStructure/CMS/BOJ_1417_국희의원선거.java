package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1417_국희의원선거 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int answer = 0;
	static int N;
	
	static class Node{
		int num;
		int cnt;
		Node(int num, int cnt){
			this.num = num;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", cnt=" + cnt + "]";
		}
		
	}
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o2.cnt - o1.cnt);
		
		Node her = new Node(1, Integer.parseInt(br.readLine()));
		for(int i = 1; i < N; i++) {
			int C = Integer.parseInt(br.readLine());
			queue.offer(new Node(i+1, C));
		}
//		System.out.println("HER : " + her);
		
		while(N != 1 && queue.peek().cnt >= her.cnt) {
			Node node = queue.poll();
//			System.out.println(node);
			node.cnt -= 1;
			her.cnt += 1;
			queue.offer(node);
			answer += 1;
//			System.out.println(Arrays.toString(queue.toArray()));
		}

		
		System.out.println(answer);
		
		
		
	}

}
