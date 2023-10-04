import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
		int [] arr = new int [N];
		for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
		
        Arrays.sort(arr);
		
		int first = 0;
		int second = 0;
		
		int left = 0;
		int right = N-1;
		int min = Integer.MAX_VALUE;
		
		while(left<right) {
			int sum= arr[left] + arr[right];
			if(Math.abs(sum) < min) {
				first = arr[left];
				second = arr[right];
				min = Math.abs(sum);
			}
			if(sum > 0 ) right--;
			else left++;
		}
		System.out.println(first +" "+ second);
	}
}