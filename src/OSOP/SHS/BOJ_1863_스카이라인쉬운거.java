package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1863_스카이라인쉬운거 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		Deque<Integer> dq = new ArrayDeque<>();
		dq.push(0);
		
		for(int i = 0; i < N;i++) {
			st = new StringTokenizer(br.readLine());
			
			// 건물의 위치는 다음 위치 전까지 같기 때문에 받을 필요 없음
			// 건물 높이의 순서만 저장하면 됨
			st.nextToken();
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int x = 0;		// index
		int result = 0; // 건물 개수
		
		
		// 다음 건물과 now가 더 낮은 건물을 만나기 전에 같은 높이라면 같은 건물임.
		// 즉, 더 낮은 건물을 만나면 pop -> result +1
		while(x < N) {
			int now = dq.peek();
			
			// 다음 건물과 높이가 같은 경우 continue
			if(arr[x] == now) {
				x++;
				continue;
			}
			
			// 다음 건물의 높이가 더 큰 경우, 다음 건물의 높이를 stack에 추가
			if(arr[x] > now) {
				dq.push(arr[x]);
			}
			
			// 다음 건물의 높이가 더 낮은 경우
			else if(arr[x] < now) {
				int temp = now;
				while(temp > arr[x]) {		// 다음 건물의 높이보다 더 높은 건물이 stack의 앞에 있을 경우
					dq.pop();				// 낮은 건물이 나올 때까지 pop
					temp = dq.peek();
					result++;
				}
				if(arr[x] == dq.peek()) {	// 다음 건물의 높이보다 앞에 있는 더 높은 건물을 모두 제외 했을때
					x++;					// 1. 같은 높이의 건물		2. 더 낮은 건물의 높이
					continue;				// 2가지 경우가 있는데, 
				}							// 같은 높이가 먼저 나온다면 같은 건물이고
				dq.push(arr[x]);			// 낮은 건물이 먼저 나온다면 다른 건물이기 때문에 dq에 push
			}
			x++;
		}
		result += dq.size()-1;				// 스택에서 다 빼기 전에 반복문이 종료 되었을 때 
											// 0을 제외한 스택에 남은 수만큼 result에 더하기
		System.out.println(result);
	}

}
