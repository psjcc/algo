package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17609_회문 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int testcase = Integer.parseInt(br.readLine());
		
		for(int tc = 0 ; tc < testcase; tc++) {
			int check = 0;
			boolean life = true;
			
			String str = br.readLine();
			int left = 0;
			int right = str.length()-1;
			System.out.println(ans(str,left,right,0));
		}
	}
	static int ans(String s, int left, int right, int now) {
		if(now == 2) {
			return now;
		}
		while(left < right) {
			if(s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			}
			else {
				now = Math.min(ans(s,left+1,right,now+1), ans(s,left,right-1,now+1));
				break;
			}
		}
		return now;
	}

}
