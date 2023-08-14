package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ_6198_옥상_정원_꾸미기 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long result = 0;
		long n = 0;
		Deque<Long> q = new ArrayDeque<>();
		for(int i = 0; i < N; i++) {
			n = Long.parseLong(br.readLine());
			while(!q.isEmpty()&& q.peekLast() <= n) {
				q.pollLast();
			}
			q.add(n);
			result += q.size()-1;
		}
		System.out.println(result);
	}

}
