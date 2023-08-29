import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17471_게리맨더링 {
	static boolean[][] table;
	static int N,min;
	static int[] popul;
	static boolean check = false;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N =Integer.parseInt(br.readLine());
		popul = new int[N];
		min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			popul[i] = Integer.parseInt(st.nextToken());
		}
		
		table = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for(int j = 0; j < n; j++) 
				table[i][Integer.parseInt(st.nextToken())-1] = true;
		}
		
		for(int i = 1; i <= 5; i++) {
			comb(new boolean[N], 0,N,i,i);
		}
		if(check)
			System.out.println(min);
		else
			System.out.println("-1");
	}
	static void comb(boolean[] selected, int depth, int n, int r,int q){
		if(r == 0) {
			int temp = ret_sum(selected,n,q);
			if(min > temp) {
				min = temp;
			}
			return;
		}
		if(depth == n) return;
		
		selected[depth] = true;
		comb(selected,depth+1,n,r-1,q);
		selected[depth] = false;
		comb(selected,depth+1,n,r,q);
	}
	
	static int ret_sum(boolean[] selected, int n,int r) {
		if(red(selected,r) && blue(selected,n-r)) {
			check = true;
			int red_sum = 0;
			int blue_sum = 0;
			for(int i = 0; i < N; i++) {
				if(selected[i]) red_sum += popul[i];
				else blue_sum += popul[i];
			}
			return Math.abs(red_sum - blue_sum);
		}
		
		return Integer.MAX_VALUE;
	}

	
	static boolean red(boolean[] selected,int size) { // size == comb.r
		int cnt = 1;
		boolean[] visited = new boolean[N];
		Deque<Integer> q = new ArrayDeque<>();
		for(int i = 0; i < selected.length;i++) {
			if(selected[i]) {q.add(i); visited[i] = true; break; }
		}
		while(!q.isEmpty()) {
			int now = q.pollFirst();
			for(int i = 0; i < table[now].length; i++) {
				if(selected[i] && !visited[i] && table[now][i]) {
					q.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}

		if(size == cnt) return true;
		return false;
		
		
	}
	static boolean blue(boolean[] selected,int size) {
		int cnt = 1;
		boolean[] visited = new boolean[N];
		Deque<Integer> q = new ArrayDeque<>();
		for(int i = 0; i < selected.length;i++) {
			if(!selected[i]) {q.add(i); visited[i] = true; break; }
		}
		while(!q.isEmpty()) {
			int now = q.pollFirst();
			for(int i = 0; i < table[now].length; i++) {
				if(!selected[i] &&!visited[i] && table[now][i]) {
					q.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		if(size == cnt) return true;
		return false;
		
		
	}
}
