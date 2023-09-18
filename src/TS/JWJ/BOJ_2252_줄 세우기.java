import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int n, m;
	static int a, b;
	static int[] indgree;
	static List<List<Integer>> graph = new ArrayList<>();
	static Queue<Integer> q = new ArrayDeque<>();
	static int node;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		indgree = new int[n + 1];
		for(int i = 0; i <= n; i++)
			graph.add(new ArrayList<>());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			indgree[b]++;
		}
		tp_sort();
		System.out.println(sb);
	}
	
	static void tp_sort() {
		for(int i = 1; i <= n; i++)
			if(indgree[i] == 0)
				q.offer(i);
		
		while(!q.isEmpty()) {
			node = q.poll();
			sb.append(node).append(" ");
			
			for (Integer i : graph.get(node)) {
				indgree[i]--;
				if(indgree[i] == 0) {
					q.offer(i);
				}
			}
			
		}
	}
}
