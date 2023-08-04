package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1907_탄소화합물 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	
	public static void f(String str, int[] cnt) {
		int pre = -1;
		for(int i = 0; i < str.length(); i++) {
			switch (str.charAt(i)) {
				case 'C':
					pre = 0;
					cnt[0] += 1;
					break;
				case 'H':
					pre = 1;
					cnt[1] += 1;
					break;
				case 'O':
					pre = 2;
					cnt[2] += 1;
					break;
				default:
					cnt[pre] += str.charAt(i) - '0' - 1;
					break;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		st = new StringTokenizer(br.readLine(), "+=");
		
		String left = st.nextToken();
		String right = st.nextToken();
		String result = st.nextToken();
		int[] L = new int[3];
		int[] R = new int[3];
		int[] RES = new int[3];
		
		f(left, L);
		f(right, R);
		f(result, RES);
		loop:
		for(int i = 1; i <=10; i++) {
			for(int j = 1; j <= 10; j++) {
				for(int k = 1; k <= 10; k++) {
					if(L[0] * i + R[0] * j == RES[0]*k) {
						if(L[1] * i + R[1] * j == RES[1]*k) {
							if(L[2] * i + R[2] * j == RES[2]*k) {
								System.out.printf("%d %d %d", i, j, k);
								break loop;
							}
						}
					}
				}
			}
		}

//		System.out.println(Arrays.toString(L));
//		System.out.println(Arrays.toString(R));
//		System.out.println(Arrays.toString(RES));
//		

		

		
//		System.out.printf("%s %s %s", left, right, result);
		

	}

}
