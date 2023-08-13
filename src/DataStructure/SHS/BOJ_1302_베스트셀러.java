package backj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


public class BOJ_1302_베스트셀러 {

	public static void main(String[] args) throws IOException{
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String, Integer>map = new HashMap<>();
		int max = 0;
		for(int i = 0; i < N; i++) {
			String book = br.readLine();
			map.put(book, map.getOrDefault(book, 0) +1);
			max = Math.max(max, map.get(book));
		}
		
		int ans_int = 0;
		String ans = "";
		Iterator<Entry<String, Integer>> iteratorE = map.entrySet().iterator();
		while(iteratorE.hasNext()) {
			Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) iteratorE.next();
			Integer value = entry.getValue();
			if(ans_int < value) {
				ans_int = value;
				ans = entry.getKey();
			}
			else if(ans_int == value){
				String ans_temp = entry.getKey(); 
				if(ans.compareTo(ans_temp) > 0) {
					ans_int = value;
					ans = entry.getKey();
				}
			}
		}
		System.out.println(ans);
	}

}
