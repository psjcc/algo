import java.util.*;
import java.io.*;

public class BOJ_1374_강의실 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer[]> l = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
		for (int i = 0;i<n;i++) {
			String[] st = br.readLine().split(" ");
			l.add(new Integer[] {Integer.parseInt(st[1]), Integer.parseInt(st[2])});
		}
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.add(l.poll()[1]);
		for (int i=1; i<n;i++) {
			if (q.peek() <= l.peek()[0]) {
				q.poll();
			}
			q.add(l.poll()[1]);
		}
		System.out.println(q.size());
	}
}
