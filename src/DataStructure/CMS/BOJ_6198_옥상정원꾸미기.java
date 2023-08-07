	package boj;
	
	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.util.Arrays;
	import java.util.Stack;
	import java.util.StringTokenizer;
	
	public class BOJ_6198_옥상정원꾸미기 {
		static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		static StringTokenizer st;
		static StringBuilder sb = new StringBuilder();
		static int N;
		static long answer = 0;
		
		static class Node{
			int height;
			int val;
			Node(int height, int val){
				this.height = height;
				this.val = val;
			}
			@Override
			public String toString() {
				return "Node [height=" + height + ", val=" + val + "]";
			}
			
		}
		
		public static void main(String[] args) throws Exception {
			 N = Integer.parseInt(br.readLine());
	
			 Stack<Node> stack = new Stack<>();
	
			 for(int i = 0 ; i < N; i++) {
				 int n = Integer.parseInt(br.readLine());
	//			 System.out.println("N : " + n);
	//			 볼수 있으면 넣음

	// 볼수 없는게 들어오면 pop

				 int cnt = 0;
				 while(!stack.isEmpty() && stack.peek().height <= n) {
					 Node tmp = stack.pop();
					 answer += cnt;
					 cnt += tmp.val + 1; 
				 }
//				 System.out.println(answer);
				 stack.push(new Node(n, cnt));
				 
	//			 System.out.println(Arrays.toString(stack.toArray()));
			 }
			 
			 int cnt = 0;
			 while(!stack.isEmpty()) {
				 Node tmp = stack.pop();
				 answer += cnt;
				 cnt += tmp.val + 1; 
			 }
			 
			 
			 System.out.println(answer);
	
		}
	
	}
