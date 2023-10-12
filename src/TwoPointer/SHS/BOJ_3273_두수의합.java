package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3273_두수의합 {
	static int n,sum;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sum = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		
		int left = 0;
		int right = n-1;
		
		int cnt = 0;
		while(left < right) {
			if(arr[left] + arr[right] == sum) {
				cnt++;
				left++;
				right--;
			}
			else if(arr[left] + arr[right] > sum) {
				right--;
			}
			else {
				left++;
			}
		}
		System.out.println(cnt);
	}
}
