package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N;
	static int[] acid, alkali, arr;
	static int result = Integer.MAX_VALUE;
	static int A, B;
	
	
	public static int BS(int start, int end) {
		
		int left = start;
		int right = end;
		int mid;
		while(left != right) {
			mid = (left + right) / 2;
			
			int val = Math.abs(arr[start - 1] + arr[mid]);
			
			if(val > Math.abs(arr[start - 1] + arr[mid + 1])) {
				left = mid + 1;
			}else if (val > Math.abs(arr[start - 1] + arr[mid - 1])) {
				right = mid;
			}
			else {
				left = mid;
				break;
			}
		}
		return arr[left];
	}
	
	public static void main(String[] args) throws Exception{
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++) {
			int solution = Integer.parseInt(st.nextToken());
			arr[i] = solution;
		}
		Arrays.sort(arr);
	
		A = 0;
		B = 0;
		int total = Integer.MAX_VALUE;
		
		for(int i = 0; i < N - 1; i++) {
			int alkali = arr[i];
			int acid = BS(i + 1, N - 1);
			if(Math.abs(alkali + acid) < Math.abs(total)) {
				A = alkali;
				B = acid;
				total = A + B;
			}
		}
		
		System.out.printf("%d %d", A, B);
		
		
		
		

	}

}
