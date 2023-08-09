package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_7662_이중우선순위큐 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int answer = 0;
	static int T, N;

	public static void main(String[] args) throws Exception {
		T = Integer.parseInt(br.readLine());

		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> {
				if(o1 > o2) return -1;
				else if (o1 < o2) return 1;
				else return 0;
			});
			PriorityQueue<Integer> minQueue = new PriorityQueue<>((o1, o2) -> {
				if(o1 > o2) return 1;
				else if (o1 < o2) return -1;
				else return 0;
			});
			HashMap<Integer, Integer> map = new HashMap<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				char command = st.nextToken().charAt(0);
				int val = Integer.parseInt(st.nextToken());
				
				switch (command) {
				case 'I':
					maxQueue.offer(val);
					minQueue.offer(val);
					map.put(val, map.get(val) == null ? 1 : map.get(val) + 1);
					break;
				case 'D':
					if(val == -1) {
						while(!minQueue.isEmpty()) {
							Integer minVal = minQueue.poll();
							if(map.get(minVal) > 0) {
								map.put(minVal, map.get(minVal) - 1);
								break;
							}
						}
					}
					else if (val == 1) {
						while(!maxQueue.isEmpty()) {
							Integer maxVal = maxQueue.poll();
							if(map.get(maxVal) > 0) {
								map.put(maxVal, map.get(maxVal) - 1);
								break;
							}
						}
					}
					break;
				}
				
//				System.out.println(Arrays.toString(maxQueue.toArray()));
//				System.out.println(Arrays.toString(minQueue.toArray()));
//				System.out.println(map.toString());
//				System.out.println("=========================================");
				
			}
			
			Integer max = null;
			Integer min = null;
//			비었으면 EMPTY

//			아니면 최대 최소 하나씩
			while(!maxQueue.isEmpty()) {
				Integer maxVal = maxQueue.poll();
				if(map.get(maxVal) > 0) {
					max = maxVal;
					break;
				}
			}
			while(!minQueue.isEmpty()) {
				Integer minVal = minQueue.poll();
				if(map.get(minVal) > 0) {
					min = minVal;
					break;
				}
			}
			
			if(max == null || min == null) {
				System.out.println("EMPTY");
			}
			else {
				System.out.printf("%d %d\n",max, min);
			}
			
		}
		
		
	}

}
