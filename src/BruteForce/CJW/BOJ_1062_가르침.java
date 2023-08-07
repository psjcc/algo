import java.util.*;
public class BOJ_1062_가르침 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k =sc.nextInt();
		boolean[][] word = new boolean[n][];
		boolean[] base = new boolean[26];
		base['a'-'a'] = true; base['c'-'a'] = true; base['i'-'a'] = true; base['n'-'a'] = true; base['t'-'a'] = true;
		for (int l=0;l<n;l++) {
			boolean[] w=base.clone();
			char[] t = sc.next().toCharArray();
			for (int i=3; i<t.length-4;i++) w[t[i]-'a'] = true;
			word[l] = w;
		}
		int ans=0;
		for (int i=1; i <(1<<26); i++){
			if ((i|532741)==i && Integer.bitCount(i) == k) {
				int t = 0;
				for (int w=0; w<n; w++) {
					for (int j=0; j<26; j++) {
						if (i != (i|(1<<j)) && word[w][j]) break;
						if (j==25) t++; 
					}
				}
				if (ans<t) ans = t;
			}
		}
		System.out.println(ans);
	}
}
