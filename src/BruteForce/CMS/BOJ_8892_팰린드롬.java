package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_8892_팰린드롬 {
	static int T;
	static int K;
	static String[] words;
	static String[] targets = new String[2];
	static boolean flag;
	
	
	public static boolean P(String str) {
		int left = 0;
		int right = str.length() - 1;
		while(left < right) {
			if(str.charAt(left) != str.charAt(right)) return false;
			left += 1;
			right -= 1;
		}
		
		return true;
	}
	
	public static void comb(int idx, int tdx) {
		if(flag) return;
		if(tdx == 2) {
//			System.out.printf("%s %s\n", targets[0], targets[1] );
			
			String pStr1 = targets[0] + targets[1];
			String pStr2 = targets[1] + targets[0];
			if(P(pStr1)) {
				System.out.println(pStr1);
				flag = true;
			}
			else if(P(pStr2)) {
				System.out.println(pStr2);
				flag = true;
			}
			return;
		}
		
		if(idx == K) return;
		
		targets[tdx] = words[idx];
		comb(idx + 1, tdx + 1);
		comb(idx + 1, tdx);
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T ; t++) {
			K = Integer.parseInt(br.readLine());
			words = new String[K];
			flag = false;
			for(int k = 0; k < K; k++) {
				String str = br.readLine();
				words[k] = str;
			}
			
			comb(0, 0);
			if(!flag) System.out.println(0);
		}

	}

}
