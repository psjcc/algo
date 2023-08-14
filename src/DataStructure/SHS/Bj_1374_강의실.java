package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Bj_1374_강의실 {

	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		List<Time> times = new ArrayList<>();
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			times.add(new Time(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
			
		}
		Collections.sort(times);
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		
		int max = 1;
		
		for(int i = 0; i < N ; i++) {
			while(!q.isEmpty()&&q.peek()<=times.get(i).start) {
				q.poll();
			}
			q.offer(times.get(i).end);
			max = Math.max(max, q.size());
		}
		System.out.println(max);
	}

}
class Time implements Comparable<Time>{
	int num;
	int start;
	int end;
	
	@Override
	public int compareTo(Time t) {
		if(this.start == t.start) return this.end - t.end;
		return this.start - t.start;
	}
	
	public Time(int num, int start, int end) {
		this.num = num;
		this.start = start;
		this.end = end;
	}
}
