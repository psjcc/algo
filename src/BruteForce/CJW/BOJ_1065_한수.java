import java.util.Scanner;

public class BOJ_1065_한수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int ans =Math.min(n, 99);
		char[] crr;
		for (int i=111; i<=n; i++) {
			crr = Integer.toString(i).toCharArray();
			if (crr[0]+crr[2] == 2*crr[1]) ans+=1;
		}
		System.out.println(ans);
	}

}
