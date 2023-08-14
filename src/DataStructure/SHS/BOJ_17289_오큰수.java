package backj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17289_오큰수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Deque<Integer> stack = new ArrayDeque<>();
		
		for(int i = 0; i < N; i++) {
			while(!stack.isEmpty() && arr[i] > arr[stack.peekFirst()]) {
				arr[stack.pop()] = arr[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) arr[stack.pop()] = -1;
		
		for(int i = 0; i < N; i++) {
			bw.write(arr[i] + " ");
		}
		bw.flush();
		bw.close();
	}

}
