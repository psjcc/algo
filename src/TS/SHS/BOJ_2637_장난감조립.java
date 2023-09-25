package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2637_장난감조립 {
	static int N,M;
	static List<Node>[] graph;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine()); // 목표 완성품
		int M = Integer.parseInt(br.readLine()); // 입력 엣지 수
		
		graph = new ArrayList[N+1];
		int edge[] = new int[N+1];	// 위상정렬 엣지
		int basic[] = new int[N+1]; // 기본 재료 판별용 배열
		int result[] = new int[N+1]; // 답
		for(int i = 0; i < N+1; i++) graph[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {  // 입력
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cnt = Integer.parseInt(st.nextToken());
			graph[from].add(new Node(to,cnt));
			basic[from]++;				// 기본 재료을 찾기 위한 배열 (basic[index] == 0 -> 기본 재료) <- 나가는 엣지가 있다면 해당 노드의 인덱스값 ++
			edge[to]++;					// 위상 정렬을 사용하기 위해 들어오는 엣지를 저장
		}
		
		// 위상정렬
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(N,1));
		result[N] = 1;
		while(!q.isEmpty()) {
			Node now = q.poll();

			for(int i = 0; i < graph[now.to].size(); i++) {
				Node next = graph[now.to].get(i);

				edge[next.to]--;
				result[next.to] += result[now.to] * next.cnt;		// now 재료의 필요 개수 * now 재료를 만들기 위한 재료(next)의 개수
				if(edge[next.to] == 0) q.add(next); // 기본재료에 도착하기 전까지 q에 추가
			}
			
		}
		
		for(int i = 1; i < N+1; i++) {
			if(basic[i] == 0) System.out.println(i + " " + result[i]); // 나가는 엣지가 없는 재료(기본재료)의 필요개수만 출력
		}
	}
	static class Node{
		int to, cnt;

		public Node(int to, int cnt) {
			super();
			this.to = to;
			this.cnt = cnt;
		}
		
	}
}
