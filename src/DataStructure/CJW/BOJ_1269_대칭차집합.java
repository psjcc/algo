import java.util.*;
import java.io.*;
public class BOJ_1269_대칭차집합 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st= br.readLine().split(" ");
		int n=Integer.parseInt(st[0]), m=Integer.parseInt(st[1]);
		HashSet<Integer> A = new HashSet<>(n);
		HashSet<Integer> B = new HashSet<>(m);
		st = br.readLine().split(" ");
		for (int i=0; i<n; i++) A.add(Integer.parseInt(st[i]));
		st = br.readLine().split(" ");
		for (int i=0; i<m; i++) B.add(Integer.parseInt(st[i]));
		A.retainAll(B);
		System.out.println(n+m-2*A.size());
	}

}
