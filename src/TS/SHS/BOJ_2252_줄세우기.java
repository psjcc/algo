package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2252_줄세우기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<Integer>[] graph = new ArrayList[N+1];
		for(int i = 1; i < N+1; i++) graph[i] = new ArrayList<>();
		int[] arr = new int[N+1];
		
		boolean[] visited = new boolean[N+1];
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph[from].add(to);
			arr[to]++; 
		}
		
		Queue<Integer> q = new LinkedList<>();
		for(int i = 1; i <N+1; i++) {
			if(arr[i] == 0) {
				q.add(i);
				visited[i] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			bw.append(now + " ");
			for(int i = 0; i < graph[now].size(); i++) {
				arr[graph[now].get(i)]--;
			}
			for(int i =1; i < N+1; i++) {
				if(!visited[i] && arr[i] == 0) {
					q.add(i);
					visited[i] = true;
				}
			}
			
		}
		bw.flush();
		bw.close();
	}

}