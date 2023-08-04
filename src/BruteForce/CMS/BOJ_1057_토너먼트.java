package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1057_토너먼트 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, J, H;
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		J = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		int n = N;
		int round = 0;
		while( n > 1) {
			round += 1;
			
			
			
			J = (J + 1) / 2;
			H = (H + 1) / 2;

			if( n % 2 == 0) {
				n = n / 2;
			}
			else {
				n = n / 2 + 1;
			}
			
			if(J == H) {
				System.out.printf("%d", round);
				break;
			}
		}
		
		
		
		

	}

}
