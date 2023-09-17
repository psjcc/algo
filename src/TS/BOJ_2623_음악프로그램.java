import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_2623_음악프로그램{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int[] indegree;
	static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
	static Deque<Integer> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		indegree = new int[N + 1];
		
		for(int i = 0; i <= N; i++) {
			adjList.add(new ArrayList<Integer>());
		}
		

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int numOfSinger = Integer.parseInt(st.nextToken());
			
			int pre = Integer.parseInt(st.nextToken());
			for(int n = 1; n < numOfSinger; n++) {
				int next = Integer.parseInt(st.nextToken());
				
				adjList.get(pre).add(next);
				indegree[next] += 1;
				pre = next;
			}
			
		}
		int cnt = 0;
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				queue.offer(i);
				cnt += 1;
			}
		}
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			sb.append(cur).append('\n');
			
			for(Integer next : adjList.get(cur)) {
				indegree[next] -= 1;
				if(indegree[next] == 0) {
					queue.offer(next);
					cnt += 1;
				}
			}
		}

		System.out.print(cnt == N ? sb : 0);
		
		
		

	}

}