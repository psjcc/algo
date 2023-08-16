import java.util.*;
import java.io.*;
public class BOJ_6198_옥상정원꾸미기 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long ans=0;
		Deque<Integer[]> q = new ArrayDeque<>();
		int now;
		Integer[] bef;
		for (int i=0; i<n; i++) {
			now = Integer.parseInt(br.readLine());
			while (!q.isEmpty() && q.peek()[0]<=now) {
				bef = q.poll();
				ans += i-bef[1]-1;
			}
			q.push(new Integer[] {now, i});
		}
		while (!q.isEmpty()) {
			bef = q.poll();
			ans += n-bef[1]-1;
		}
		System.out.println(ans);
	}
}
