package bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj_10828{
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int testcase = Integer.parseInt(br.readLine());
		Stack<Integer> stc = new Stack<>();
		for(int tc= 1; tc <= testcase; tc++) {
			st = new StringTokenizer(br.readLine());
			switch(st.nextToken()) {
			case "push": {stc.add(Integer.parseInt(st.nextToken())); break;}
			case "pop": {if(stc.isEmpty()) System.out.println("-1"); else {System.out.println( stc.pop());} break;}
			case "size": {System.out.println( stc.size()); break;}
			case "empty": {if(stc.isEmpty()) System.out.println("1"); else System.out.println("0"); break;}
			case "top": {if(!stc.isEmpty()) System.out.println( stc.peek()); else System.out.println("-1"); break;}
			}
		}
	}
}