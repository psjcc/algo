import java.util.Scanner;

public class 달팽이 {
	static int s;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			System.out.println("#"+t);
			int n = sc.nextInt();
			s=1;
			int[][] arr = go(n);
			for (int[] line: arr) {
				for (int l : line) System.out.print(""+l+" ");
				System.out.println();
			}
		}
	}
	
	public static int[][] go(int n) {
		if (n==0) return new int[][] {{}};
		if (n==1) return new int[][] {{s++}};
		int[][] arr = new int[n][n];
		for (int i=0; i<n; i++) arr[0][i] = s++;
		for (int i=1; i<n; i++) arr[i][n-1] = s++;
		for (int i=n-2; i>=0; i--) arr[n-1][i] = s++;
		for (int i=n-2; i>0; i--) arr[i][0] = s++;
		int[][] inarr = go(n-2);
		for (int i=1; i<n-1; i++) {
			for (int j=1; j<n-1; j++) {
				arr[i][j] = inarr[i-1][j-1];
			}
		}
		return arr;
	}
}
