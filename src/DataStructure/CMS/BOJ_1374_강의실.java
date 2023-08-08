package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1374_강의실 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> { 
			if(o1.end == o2.end) return o1.start - o2.start;
			return o1.end - o2.end;
		});
	static int N, K;
	static Node[] arr;
	static class Node{
		int num;
		int start;
		int end;
		Node(int num, int start, int end){
			this.num = num;
			this.start = start;
			this.end = end;
		}
		@Override
		public String toString() {
			return "Node [num=" + num + ", start=" + start + ", end=" + end + "]";
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		arr = new Node[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			arr[i] = new Node(num, start, end);
		}
		
		Arrays.sort(arr, (o1, o2) -> o1.start - o2.start);
		queue.offer(arr[0]);

		for(int i = 1; i < N; i++) {
//			System.out.println(queue.peek());
			if(queue.peek().end <= arr[i].start) {
				queue.poll();
				queue.offer(arr[i]);
			}
			else {
				queue.offer(arr[i]);
			}
//			System.out.println(Arrays.toString(queue.toArray()));
		}
		System.out.println(queue.size());

		
	}

}
