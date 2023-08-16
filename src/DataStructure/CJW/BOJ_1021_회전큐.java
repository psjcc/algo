import java.util.*;
import java.io.*;
public class Main {
	static Deque<Integer> q;
	static int n,m;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		n=Integer.parseInt(st[0]);
		m=Integer.parseInt(st[1]);
		q = new ArrayDeque<>(n);
		for (int i=1; i<=n; i++) q.addLast(i);
		st = br.readLine().split(" ");
		int ans=0;
		for (int i=0; i<m; i++) {
			ans += l_or_r(Integer.parseInt(st[i]));
		}
		System.out.println(ans);
	}
	public static int l_or_r(int i) {
		int r=0;
		while (q.peek() != i) {q.addLast(q.pop()); r++;}
		q.pop();
		r = Math.min(r, n-r);
		n--;
		return r;
	}
}