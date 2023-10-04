import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n=Integer.parseInt(st[0]),s=Integer.parseInt(st[1]);
		int mid = n/2;
		int[] arr = new int[mid];
		int[] brr = new int[n-mid];
		st = br.readLine().split(" ");
		for (int i=0; i<mid; i++) arr[i] = Integer.parseInt(st[i]);
		for (int i=mid; i<n; i++) brr[i-mid] = Integer.parseInt(st[i]);
		HashMap<Long, Long> amap = subset(arr, mid);
		HashMap<Long, Long> bmap = subset(brr, n-mid);
		long ans=0;
		for (Map.Entry<Long, Long> en : amap.entrySet()){
			if (bmap.containsKey(s- en.getKey())) {
				ans += bmap.get(s-en.getKey()) * en.getValue();
			}
		}
		if (s==0) ans-=1;
		System.out.println(ans);
	}
	public static HashMap<Long, Long> subset(int[] arr, int size){
		HashMap<Long, Long> map = new HashMap<>();
		map.put((long)0,(long)1);
		for (int i=1; i<(1<<size); i++){
			long t=0;
			for (int j=0; j<size; j++){
				if (i == (i|(1<<j))) t+= arr[j];
			}
			if (map.containsKey(t)) map.put(t, map.get(t)+1);
			else map.put(t, (long)1);
		}
		return map;
	}
}