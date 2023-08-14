import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335_트럭 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb;
	static int answer = 0;
	static int N, W, L;
	
	static class Node{
		int val;
		int num;
		
		Node(int val, int num){
			this.val = val;
			this.num = num;
		}
	}

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		Queue<Integer> queue = new LinkedList<>();
		Queue<Integer> bridge = new LinkedList<>();
		
		
		for(int i = 0; i < N; i++) {
			queue.offer(Integer.parseInt(st.nextToken()));
		}
		
		
		for(int i = 0; i < W; i++) {
			bridge.offer(0);
		}
		
		int cnt = 0;
		int weight = 0;
		int time = 0;
		while(cnt < N) {
			
			int head = bridge.poll();
			if(head > 0 ) {
				cnt += 1;
				weight -= head;
			}
			
			if(!queue.isEmpty() && queue.peek() + weight <= L) {
				int last = queue.poll();
				bridge.offer(last);
				weight += last;
			}
			else {
				bridge.offer(0);
			}
			
			time += 1;
		}
		
		System.out.println(time);
		
		
		
		

 
	}

}