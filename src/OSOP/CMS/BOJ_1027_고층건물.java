import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] building;
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		
		building = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			building[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = 0;
		
		for(int i = 0; i < N; i++) {
			double incline = -Double.MAX_VALUE;
			int cnt = 0;
			int cur = building[i];
			
			for(int left = i - 1; left >=0; left--) {
				int diffHeight = building[left] - cur; 
				
				double distance = Math.abs(i - left);
				double newIncline = diffHeight /distance;
//				System.out.println(newIncline);
				
				if(newIncline > incline) {
					cnt +=1;
					incline = newIncline;
				}
				
			}
//			System.out.println(cnt);
			
			incline = -Double.MAX_VALUE;
			for(int right = i + 1; right < N; right++) {
				int diffHeight = building[right] - cur; 
				
				double distance = Math.abs(i - right);
				double newIncline = diffHeight / distance ; 
				
				if(newIncline > incline) {
					cnt +=1;
					incline = newIncline;
				}
				
			}

			answer = Math.max(answer, cnt);
			
			
		}
		
		
		System.out.println(answer);
	}

}