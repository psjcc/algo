package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1065_한수 {
	static int N;

	static int answer = 0;

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(br.readLine());

		for(int n = 1; n <= N; n++) {
			Integer num = n;
			
			String s = num.toString();
			if(s.length() == 1) {
				answer +=1;
				continue;
			}
			int d = s.charAt(0) - s.charAt(1);
			for(int i = 1; i < s.length(); i++) {
				
				if(s.charAt(i - 1) - s.charAt(i) != d) {
					break;
				}
				if(i == s.length() - 1) answer += 1;
			}
			
			
		}
		System.out.println(answer);

	}

}