package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj_1244 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		boolean[] arr = new boolean[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x == 0)
				arr[i] = false;
			else
				arr[i] = true;
		}
		
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(sex == 1) {
				int num_ = num;				
				while(num_-1 < N) {
					arr[num_-1] = !arr[num_-1];
					num_+=num;
				}
			}
			
			else {
				arr[num-1] = !arr[num-1];
				int x = 1;
				while(0<=num-x-1&&num+x-1<N) {
					if(arr[num+x-1] != arr[num-x-1]) {
						break;
					}
					arr[num+x-1] = !arr[num+x-1];
					arr[num-x-1] = !arr[num-x-1];
					x++;
				}
			}
		}
		
		for(int i = 1; i <= arr.length;i++) {
			if(arr[i-1]) System.out.print("1 ");
			else System.out.print("0 ");
			if(i % 20 == 0) System.out.println();
		}
			
	}

}
