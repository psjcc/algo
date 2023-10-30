import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_2109_순회강연 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int N;
	static int answer = 0;
	
	static PriorityQueue<Lecture> heap = new PriorityQueue<>((o1, o2) ->{
		
		return o1.p == o2.p ? o2.d - o1.d : o2.p - o1.p;
	});
	
	
	static class Lecture{
		int p, d;
		Lecture(int p, int d){
			this.p = p;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			heap.offer(new Lecture(p, d));
		}
		
		
		boolean[] checked = new boolean[10001];
		
		while(!heap.isEmpty()) {
			Lecture cur = heap.poll();
			
			for(int i = cur.d; i >= 1 ; i--) {
				if(checked[i]) continue;
				
				checked[i] = true;
				answer += cur.p;
				break;
				
			}
		}
		

		System.out.println(answer);
	}

}