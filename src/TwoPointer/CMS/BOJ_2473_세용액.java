package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473_세용액 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static long[] solution;
    static long[] result = new long[3];
    static long minVal = Long.MAX_VALUE;
    
    public static long[] f(int idx, int start, int end) {
    	
    	long[] res = new long[3];
    	
        int left = start;
        int right = end;
        long mixed = Long.MAX_VALUE;
        
        while(true) {
        	
        	if(left >= right) break;

	         long sum = solution[left] + solution[right] + solution[idx];
             
             if(mixed > Math.abs(solution[left] + solution[right] + solution[idx])) {
            	 mixed = Math.abs(solution[left] + solution[right] + solution[idx]);
    	       	 res[0] = solution[idx];
    	         res[1] = solution[left];
    	         res[2] = solution[right];
             }
             
             
             if(sum > 0)
                 right--;
             else
                 left++;
            
        }
        
       
        return res;
    }

    public static void main(String[] args) throws Exception{
        N = Integer.parseInt(br.readLine());

        
        solution = new long[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            solution[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(solution);
        
        long[] res = null;
        for(int i = 0; i < N - 2; i++) {
        	res = f(i, i + 1, N - 1);
        	long val = Math.abs(res[0] + res[1] + res[2]);
        	System.out.println(i);
        	System.out.println(Arrays.toString(res));
        	if(minVal > val) {
        		result = res;
        		minVal = val;
        	}
        	System.out.println(Arrays.toString(result));
        }
        
        Arrays.sort(result);
        
        System.out.printf("%d %d %d", result[0], result[1], result[2]);
        
        

        
        
    }

}