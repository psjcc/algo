import java.io.*;
import java.util.*;
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] psum = new int[n+1];
        psum[0] = 0;
        int ans=n+1, t;
        for (int i=0; i<n; i++){
            t = Integer.parseInt(st.nextToken());
            psum[i+1] = psum[i] + t;
            if (t>=S) ans=1;
        }
        int s=1, e=1;
        while (s<=n && e<=n && s<=e){
            int now = psum[e]-psum[s-1];
            if (now >= S){
                ans = Math.min(ans, e-s+1);
                if (ans==1) break;
                s++;
            } else if (now < S) e++;
        }
        System.out.println(ans<=n ? ans:0);
    }
}
