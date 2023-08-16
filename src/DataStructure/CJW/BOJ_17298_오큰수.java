import java.io.*;
import java.util.*;
public class BOJ_17298_오큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] st = br.readLine().split(" ");
		Deque<Integer> q = new ArrayDeque<>();
		int now;
		int[] ans = new int[n];
		for (int i=n-1; i>=0; i--) {
			now = Integer.parseInt(st[i]);
			while (!q.isEmpty() && q.peek() <= now) q.poll();
			ans[i] = q.isEmpty() ? -1:q.peek();
			q.push(now);
		}
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) sb.append(ans[i]).append(" ");
		System.out.println(sb);
	}
}
