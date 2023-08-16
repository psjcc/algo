import java.util.*;
import java.io.*;
public class BOJ_1417_국회의원 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> heap = new PriorityQueue<>((l1,l2)-> l2-l1);
		for (int i=1; i<n; i++) heap.add(Integer.parseInt(br.readLine()));
		int ans=0;
		while (n>1 && heap.peek() >= t) {
			ans++;
			t++;
			heap.add(heap.poll()-1);
		}
		System.out.println(ans);
	}
}