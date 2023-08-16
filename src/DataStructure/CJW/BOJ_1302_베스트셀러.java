import java.io.*;
import java.util.*;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;
public class BOJ_1302_베스트셀러 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()), max=0;
		HashMap<String, Integer> map = new HashMap<>();
		String ans="";
		for (int i=0;i<n;i++) {
			String k = br.readLine();
			if (map.containsKey(k)) map.put(k, map.get(k)+1);
			else map.put(k,1);
		}
		for (Map.Entry<String,Integer> e: map.entrySet()) {
			if (max<e.getValue()) {ans=e.getKey(); max=e.getValue();}
			else if (max==e.getValue()) {
				if (ans.compareTo(e.getKey())>0) ans = e.getKey();
			}
		}
		System.out.println(ans);
	}
}
