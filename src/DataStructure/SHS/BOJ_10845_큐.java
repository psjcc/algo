package bj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Bj_10845{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Deque<Integer> q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			String str = br.readLine();
			st = new StringTokenizer(str);
			switch(st.nextToken()){
				case "push": q.add(Integer.parseInt(st.nextToken())); break;
					
				case "pop": if(!q.isEmpty()) bw.write(String.valueOf(q.pollFirst()) + "\n"); else bw.write("-1" + "\n"); break;
				case "size": bw.write(String.valueOf(q.size()) + "\n"); break;
				case "empty": if(q.isEmpty()) bw.write("1" + "\n"); else bw.write("0" + "\n"); break;
				case "front": if(!q.isEmpty()) bw.write(String.valueOf(q.peekFirst()) + "\n"); else bw.write("-1" + "\n"); break;
				case "back": if(!q.isEmpty()) bw.write(String.valueOf(q.peekLast()) + "\n"); else bw.write("-1" + "\n"); break;
			}
		}
		bw.flush();
		bw.close();
	}
	
}