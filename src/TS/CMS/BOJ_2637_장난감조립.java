import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2637_장난감조립 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static ArrayList<ArrayList<Node>> adjList = new ArrayList<>();
	static int[][] adj;
	static int[] indegree;
	static int[] result;
	static int[] dp;
	
	static class Node{
		int from;
		int to;
		int cnt;
		
		Node(int from, int to, int cnt){
			this.from = from;
			this.to = to;
			this.cnt = cnt;
		}
		
	}

	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		indegree = new int[N + 1];
		dp = new int[N + 1];
		adj = new int[N + 1][N + 1];
		for(int i = 0; i <= N ; i++) {
			adjList.add(new ArrayList<Node>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			adjList.get(y).add(new Node(y,x,k));
			adj[x][y] = k;
			indegree[x] += 1;
		}
		
		Deque<Integer> queue = new LinkedList<>();
		
		for(int i = 1 ; i <=N; i++) {	
			if(indegree[i] == 0) {
				queue.offer(i);
				indegree[i] = -1;
			}
		}
		

		ArrayList<Integer> result = new ArrayList<>();
		
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			result.add(cur);
			for(Node next : adjList.get(cur)) {
				indegree[next.to] -= 1;
				if(indegree[next.to] == 0) {
					queue.offer(next.to);
				}
			}
		}
		
		dp[N] = 1;
		for(int i = result.size() - 1; i >= 0 ; i--) {
			int n = result.get(i);
			

			for(int k = 1; k < N + 1; k++) {
				dp[k] += adj[n][k] * dp[n];
			}


		}
		
		
		for(int i = 1; i < N + 1; i++) {
			if(indegree[i] == -1) {
				sb.append(i).append(' ').append(dp[i]).append('\n');
			}
		}
		
		System.out.print(sb);
		
		

	}

}