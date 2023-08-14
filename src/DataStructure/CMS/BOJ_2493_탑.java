package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	
	static class Node{
		int height;
		int index;
		Node(int height, int index){
			this.height = height;
			this.index = index;
		}
	}
	
	public static void main(String[] args) throws Exception {
		 N = Integer.parseInt(br.readLine());
		 st = new StringTokenizer(br.readLine(), " ");
		 Stack<Node> stack = new Stack<>();

		 for(int i = 1 ; i <= N; i++) {
			 int n = Integer.parseInt(st.nextToken());

			 while(!stack.isEmpty() && stack.peek().height < n) {
				 stack.pop();
			 }
			 
			 if(stack.isEmpty()) sb.append(0).append(" ");
			 else sb.append(stack.peek().index).append(" ");
			 stack.push(new Node(n , i));
		 }
		 
		 System.out.println(sb);

	}

}
