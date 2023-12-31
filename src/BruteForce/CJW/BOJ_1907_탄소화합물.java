import java.io.*;
import java.util.*;

public class BOJ_1907_탄소화합물 {
	static int[][] X;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = new StringTokenizer(sc.next(), "+=");
		HashMap<Character, Integer> atom = new HashMap<>();
		atom.put('C', 0);
		atom.put('O', 1);
		atom.put('H', 2);
		X = new int[3][3];
		for (int i=0; i<3; i++) {
			X[i] = new int[] {0, 0, 0};
			char[] form =  st.nextToken().toCharArray();
			for (int j=0; j<form.length; j++) {
				char c = form[j];
				if (c>'A') X[i][atom.get(c)] += 1;
				else {
					c = form[j-1];
					for (char k ='1'; k<form[j]; k++) X[i][atom.get(c)] += 1;
				}
			}
		}
		l:for (int a=1; a<=10; a++) {
			for (int b=1; b<=10; b++) {
				for (int c=1; c<=10; c++) {
					if (check(a,b,c, 0) && check(a,b,c, 1) && check(a,b,c, 2)) {
						System.out.println(""+a+" "+b+" "+c);
						break l;
					}
				}
			}
		} // l
	}// main
	public static boolean check(int a, int b, int c, int i) {
		return a*X[0][i]+b*X[1][i] == c*X[2][i];
	}
}
