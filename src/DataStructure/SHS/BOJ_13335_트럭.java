package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13335_트럭 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		Queue<Integer> truck = new LinkedList<>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			truck.offer(Integer.parseInt(st.nextToken()));
		}
		
		int time = 0;
		int weight = 0;
		Queue<Integer> bridge = new LinkedList<>();
		for(int i = 0; i < W; i++) {
			bridge.add(0);
		}
		
		while(!bridge.isEmpty()) {
			time++;
			weight -= bridge.poll();
			if(!truck.isEmpty()) {
				if(truck.peek() + weight <= L) {
					weight += truck.peek();
					bridge.add(truck.poll());
				}
				else {
					bridge.add(0);
				}
			}
		}
		System.out.println(time);
	}

}
