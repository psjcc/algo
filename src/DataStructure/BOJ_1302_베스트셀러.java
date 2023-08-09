import java.io.*;
import java.util.*;
public class BOJ_1302_베스트셀러 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<>();
		String ans="";
		for (int i=0;i<n;i++) {
			String k = br.readLine();
			if (map.containsKey(k)) map.put(k, map.get(k)+1);
			else map.put(k,1);
			if (ans.equals("")) ans=k;
			if (map.get(ans)<map.get(k)) ans = k;
		}
		System.out.println(ans);
	}

}
