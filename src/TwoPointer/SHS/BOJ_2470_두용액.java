package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470_두용액 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N  = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0;
		int right = N-1;
		int min = 2000000001;
		int result_left = 0;
		int result_right = N-1;
		Arrays.sort(arr);
		while(left < right) {
			int temp = arr[left] + arr[right];
			if(Math.abs(temp) < Math.abs(min)) {
				result_left = left;
				result_right = right;
				min = temp;
			}
			if((temp < 0 && arr[right] <= 0)||(temp < 0 && arr[left] <= 0 && arr[right] >= 0)) left++;
			else if ((temp > 0 && arr[left] <= 0 && arr[right] >= 0)|| (temp > 0 && arr[left] >= 0)) right--;
			else break;
		}
		
		System.out.println(arr[result_left] + " " + arr[result_right]);
	}

}
