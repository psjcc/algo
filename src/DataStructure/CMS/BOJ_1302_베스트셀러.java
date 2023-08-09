package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class BOJ_1302_베스트셀러 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static HashMap<String, Integer> map = new HashMap<>();
	public static void main(String[] args) throws Exception{
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; i++) {
			String book = br.readLine();
			map.put(book, map.getOrDefault(book, 0) + 1);
		}
		
		String answer = null;
		int maxVal = 0;
		
		Object[] arr = map.keySet().toArray();
		Arrays.sort(arr);
		for(Object key : arr) {
			if(map.get(key) > maxVal) {
				answer = (String)key;
				maxVal = map.get(key);
			}
		}
		
		System.out.println(answer);
	
	}
}
