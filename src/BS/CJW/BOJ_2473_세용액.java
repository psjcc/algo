import java.io.*;
import java.util.*;
public class Main {
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Long> sol = new ArrayList<>(n);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) sol.add(Long.parseLong(st.nextToken()));
        
        Collections.sort(sol);
        long[] res_sol = {sol.get(0), sol.get(1), sol.get(2)};
        int s, e;
        long three, res=Math.abs(res_sol[0]+res_sol[1]+res_sol[2]);
        l :for (int i=0; i<n-2; i++){
            s=i+1; e=n-1;
            while (s<=n-2 && s<e) {
                three = sol.get(i) + sol.get(s) + sol.get(e);
                if (res>Math.abs(three)) {
                    res = Math.abs(three);
                    res_sol = new long[] {sol.get(i), sol.get(s), sol.get(e)};
                }
                
                if (three==0) break l;
                if (three<0) s++;
                else e--;
            }
        }
        System.out.printf("%d %d %d", res_sol[0], res_sol[1], res_sol[2]);
    }
}