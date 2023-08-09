package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_1269_대칭차집합 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, M, answer;
	static HashSet<Integer> A = new HashSet<>();
	static HashSet<Integer> B = new HashSet<>();
	public static void main(String[] args) throws Exception{
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			B.add(Integer.parseInt(st.nextToken()));
		}
		answer = N + M;
		HashSet<Integer> S = A.size() > B.size() ? A : B;
		S.forEach((num) ->{
			if(A.contains(num) && B.contains(num)) {
				answer -= 2;
			}
		});
		
		System.out.println(answer);
	
	}
}
