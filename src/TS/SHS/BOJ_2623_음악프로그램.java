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

public class BOJ_2623_음악프로그램 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[] visited = new boolean[N+1];
		List<Integer>[] graph = new ArrayList[N+1];
		for(int i =1; i< N+1; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] arr= new int[N+1];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int[] singer = new int[num];
			for(int j = 0; j <num; j++) singer[j] = Integer.parseInt(st.nextToken());
			for(int j = 1; j < num; j++) {
				arr[singer[j]]++;
				graph[singer[j-1]].add(singer[j]);
			}
			
			
		}
		System.out.println();
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i < N+1; i++) {
			if(arr[i] <= 0) {
				q.add(i);
				visited[i] = true;
			}
		}
		
		while(!q.isEmpty()) {
			int now = q.poll();
			bw.append(now + "\n");
			for(int i = 0; i < graph[now].size(); i++) {
				arr[graph[now].get(i)]--;
				if(arr[graph[now].get(i)] <= 0 && !visited[graph[now].get(i)]) {
					q.add(graph[now].get(i));
					visited[graph[now].get(i)] = true;
				}
			}
			
		}
		boolean check = true;
		for(int i = 1; i < N+1; i++) {
			if(!visited[i]) check = false;
		}
		if(check) bw.flush();
		else System.out.println("0");
		bw.close();
	}

}