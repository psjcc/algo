import java.io.*;
import java.util.*;
public class BOJ_18258_queue2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> q = new ArrayDeque<>();
		String[] st;
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<n; i++) {
			st = br.readLine().split(" ");
			switch (st[0]) {
				case "push":	
					q.addLast(Integer.parseInt(st[1]));
					break;
				case "pop":
					sb.append(q.isEmpty() ? -1:q.pop()).append("\n");
					break;
				case "size":
					sb.append(q.size()).append("\n");
					break;
				case "empty":
					sb.append(q.isEmpty() ? 1:0).append("\n");
					break;
				case "front":
					sb.append(q.isEmpty() ? -1:q.peek()).append("\n");
					break;
				case "back":
					sb.append(q.isEmpty() ? -1:q.peekLast()).append("\n");
					break;
			}
		}
		System.out.println(sb);
	}

}
