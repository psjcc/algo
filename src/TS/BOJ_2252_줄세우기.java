import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		indegree = new int[N + 1];
		
		for(int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			adjList.get(A).add(B);
			indegree[B] += 1;
		}
		
		Deque<Integer> queue = new LinkedList<>();
		
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) queue.offer(i);
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append(' ');
			
			for(Integer next: adjList.get(cur)) {
				indegree[next] -= 1;
				if(indegree[next] == 0) queue.offer(next);
			}
		}
		
		System.out.println(sb);
		

	}

}