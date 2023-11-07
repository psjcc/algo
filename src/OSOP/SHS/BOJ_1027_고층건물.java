package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1027_고층건물 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] answer = new int[N];
		for(int i = 0; i < N-1; i++) {
			answer[i]++;
			answer[i+1]++;
			double slope = arr[i+1] - arr[i];
			for(int j = i+2; j < N; j++) {
				double nextslope = (double)(arr[j] - arr[i])/(j-i);
				if(nextslope > slope) {
					slope = nextslope;
					answer[i]++;
					answer[j]++;
				}
			}
		}
		int result = 0;
		for(int i = 0; i < N; i++) {
			if(answer[i] > result) result = answer[i];
		}
		System.out.println(result);
	}
	
}
