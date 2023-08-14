import java.util.*;
import java.io.*;
public class BOJ_1021_회전큐 {
	static Deque<Integer> q;
	static int n,m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		n=Integer.parseInt(st[0]);
		m=Integer.parseInt(st[1]);
		q = new ArrayDeque<>(n);
		for (int i=1; i<=n; i++) q.addLast(i);
		int[] arr = new int[n];
		for (int i=0; i<n; i++) {
			for (int j=1; j<m; j++) q.addLast(q.pop());
			arr[i] = q.pop();
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<").append(arr[0]);
		for (int i=1; i<arr.length; i++) sb.append(", ").append(arr[i]);
		sb.append(">");
		System.out.println(sb);
	}
}
