package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1654_랜선자르기 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int K, N;
	static int[] nums;
	static long answer;
	
	
	public static long count(long len) {
		long cnt = 0;
		for(int i = 0; i < K; i++) {
			cnt += nums[i] / len;
		}
		
		return cnt;
	}
	
	
	public static void BS(int limit) throws Exception{
		long left = 1;
		long right = limit;
		long target;
		long cnt;
		while(left <= right) {
//			br.readLine();
			target = (left + right) / 2;
			
			cnt = count(target);
//			System.out.printf("%d %d >> %d : %d", left, right, target, cnt);
			
			if(cnt > N) {
				left = target + 1;
			}
			else if(cnt < N) {
				right = target - 1;
			}
			else if(cnt == N) {
				left = target + 1;
				
			}
			
		}
		answer = left - 1;
		
	}

	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine(), " ");
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		nums = new int[K];
		
		
		int maxVal = 0;
		for(int i = 0; i < K; i++) {
			nums[i] = Integer.parseInt(br.readLine());
			maxVal = Math.max(maxVal, nums[i]);
		}
		
		BS(maxVal);
		
		System.out.println(answer);
		
	}

}
