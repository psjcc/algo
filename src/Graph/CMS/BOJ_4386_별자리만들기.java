package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static int[] parent;
	static double[][] star;
	static Star[] starArr;
	static ArrayList<Edge> edgeList = new ArrayList<>();
	static double answer =0;
	
	static class Star{
		double x;
		double y;
		
		Star(double x, double y){
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge{
		int from;
		int to;
		double weight;
		
		Edge(int from, int to, double weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static void makeSet(int n) {
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
	}
	
	static int findSet(int x) {
		if(parent[x] == x) return x;
		else return parent[x] = findSet(parent[x]);
	}
	
	static boolean union(int a, int b) {
		int aP = findSet(a);
		int bP = findSet(b);
		
		if(aP == bP) return false;
		else {
			parent[aP] = bP;
			return true;
		}
	}
	
	
	public static void main(String[] args) throws Exception {

		N = Integer.parseInt(br.readLine());
		starArr = new Star[N];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			
			starArr[n] = new Star(x, y);
		}
		
		
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				double dist =	Math.pow((starArr[i].x - starArr[j].x), 2) + Math.pow((starArr[i].y - starArr[j].y), 2);
				edgeList.add(new Edge(i, j, dist));
			}
		}
		
		Collections.sort(edgeList, (o1, o2) -> {
			if(o1.weight < o2.weight) return -1;
			else if(o1.weight > o2.weight) return 1;
			else return 0;
		});
		
		makeSet(N);
		for(Edge e : edgeList) {
			if(union(e.from, e.to)) {
				answer += Math.sqrt(e.weight);
			}
		}
		
		
		System.out.printf("%.2f", answer);
		
		
		
		
		
		
		
	}

}
