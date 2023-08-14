package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int[] arr;
	static int N;
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[N];
		
		for(int i = N - 1; i >= 0; i--) {

			while(!stack.isEmpty() && stack.peek() <= arr[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				result[i] = -1;
			}
			else {
				result[i] = stack.peek();
			}

			stack.push(arr[i]);
		}
		
		for(int i = 0; i < N; i++) {
			sb.append(result[i]).append(' ');
		}
		System.out.print(sb);
		
		
		
		

	}

}
