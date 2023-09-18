import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4885_젤다 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[][] map;
	static PriorityQueue<Node> heap = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
	static boolean[][] visited;
	static int[][] cost;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	static final int INF = Integer.MAX_VALUE;
	
	
	static class Node{
		int row;
		int col;
		int weight;
		Node(int row, int col, int weight){
			this.row = row;
			this.col = col;
			this.weight = weight;
		}
	}
	
	
	public static void D(Node start) {
		cost[start.row][start.col] = start.weight;
		heap.add(start);
		
		while(!heap.isEmpty()) {
			
			Node cur = heap.poll();
			
			if(visited[cur.row][cur.col]) continue;
			visited[cur.row][cur.col] = true;
			
			for(int d = 0; d < 4; d++) {
				int nr = cur.row + dy[d];
				int nc = cur.col + dx[d];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
				if(map[nr][nc] + cost[cur.row][cur.col] < cost[nr][nc]) {
					cost[nr][nc] = map[nr][nc] + cost[cur.row][cur.col];
					heap.offer(new Node(nr, nc, cost[nr][nc]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		int t = 0;
		while(true) {
			
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			
			map = new int[N][N];
			cost = new int[N][N];
			visited = new boolean[N][N];
			heap = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					cost[i][j] = INF;
				}
			}
			
			D(new Node(0, 0, map[0][0]));
			
			t += 1;
			sb.append("Problem ").append(t).append(": ").append(cost[N-1][N-1]).append('\n');
			
		}
		
		System.out.print(sb);
		
		
		
		

	}

}
