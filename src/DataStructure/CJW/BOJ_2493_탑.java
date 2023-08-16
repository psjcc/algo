import java.io.*;
import java.util.*;

public class BOJ_2493_탑 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] tower = new int[n];
		String[] st = br.readLine().split(" ");
		for (int i=0; i<n; i++) tower[i] = Integer.parseInt(st[i]);
		Deque<Integer> q = new ArrayDeque<>(n);
		StringBuilder sb = new StringBuilder();
		
		for (int i=0;i<n;i++) {
			while (!q.isEmpty() && tower[q.peek()-1] < tower[i]) q.pop();
			if (q.isEmpty()) sb.append("0 ");
			else sb.append(q.peek()).append(" "); 
			q.push(i+1);
		}
		System.out.println(sb);
	}
}