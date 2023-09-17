import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
	
public class BOJ_2056_작업 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] indegree;
	static ArrayList<ArrayList<Edge>> adjList = new ArrayList<>();
	static Deque<Node> queue = new LinkedList<>();
	static Node[] list;
	static int[] result;
	static int answer = 0;
	
	
	
	static class Edge{
		int from;
		int to;
		int time;
		
		Edge(int from, int to, int time){
			this.from = from;
			this.to = to;
			this.time = time;
		}
	}
	
	static class Node{
		int num;
		int time;
		Node(int num, int time){
			this.num = num;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		N = Integer.parseInt(br.readLine());
		indegree = new int[N + 1];
		list = new Node[N+1];
		result = new int[N + 1];
		
		for(int i = 0; i < N + 1; i++) {
			adjList.add(new ArrayList<Edge>());
		}
		
		
//		간선 정보 입력 받기
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int time = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());
			
			indegree[i] = in;
			list[i] = new Node(i, time);
			result[i] = time;
			for(int j = 0; j < in; j++) {
				int pre = Integer.parseInt(st.nextToken());
				adjList.get(pre).add(new Edge(pre, i, time));
				
			}
		}
		
		
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) queue.offer(list[i]);
		}
		
		
		while(!queue.isEmpty()) {
			Node cur = queue.poll();

			for(Edge e : adjList.get(cur.num)) {
				
				indegree[e.to] -= 1;
				result[e.to] = Math.max(result[e.to], result[cur.num] + e.time);
				if(indegree[e.to] == 0) queue.offer(new Node(e.to, 0));
//				offer할 때 더하는 것은
//				indegree가 2 이상일 경우 젤 마지막에 0으로 만드는 노드의 시간만 계산되기 떄문에 안됨
			}
			
			
		}
		
		
		for(int i = 1; i <= N; i++) {
			answer = Math.max(answer, result[i]);
		}
		
		System.out.println(answer);
		
		
		
		
		

	}

}