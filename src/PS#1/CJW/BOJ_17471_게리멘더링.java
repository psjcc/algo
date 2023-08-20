import java.io.*;
import java.util.*;
public class BOJ_17471_게리멘더링 {
	static boolean[][] g;
	static int n;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		int psum = 0; // 최대 인원 누적합 << 버릇처럼 누적합 하는데 왜 했는지 모르겠음 결국 다 더하는거 같음
		g = new boolean[n][n];
		int zcnt = 0; // zcnt: 고립된 장소 count
		int znode = 0; // zcnt==1일때 쓰기위한 인접노드 위치 저장
		String[] st = br.readLine().split(" ");
		for (int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(st[i]);
			psum += arr[i];
			String[] stt = br.readLine().split(" ");
			boolean[] tem = new boolean[n];
			if (stt[0].equals("0")) {zcnt++; znode=i;}
			else for (int j=Integer.parseInt(stt[0]);j>0;j--) tem[Integer.parseInt(stt[j])-1] =true;
			g[i] = tem;
		}
		if (zcnt >=2 && n>2) System.out.println(-1); // 고립된곳이 두개 이상 + n>2라서 선거 불가능
		else if (zcnt==1) System.out.println(Math.abs(psum-arr[znode]*2)); // 고립된 곳이 하나라면 해당지점이랑 나머지랑 인구수 차이 출력
		else { // subset으로 모든 경우에서 isone()으로 연결되어있는지 검사합니다.
			int ans = Integer.MAX_VALUE;
			for (int i=1; i< 1<<(n-1); i++) {
				boolean[] group = new boolean[n]; 
				boolean[] eroup = new boolean[n];
				eroup[n-1] = true; // 한 지역을 미리 빼두면 중복 검사를 안 할 수 있음
				for (int j=0; j<n-1; j++) {
					if ((i|1<<j) == i) group[j] = true;
					else eroup[j] = true;
				}
				if (isone(group) && isone(eroup)) { // 두 선거구가 각각 연결되어있는게 맞다면
					int t = 0;
					for (int a=0; a<n; a++) if (group[a]) t+=arr[a]; 
					ans = Math.min(ans, Math.abs(psum-t*2)); // 정답 갱신
				}
			}
			System.out.println(ans);
		}
	} // main
	
	static boolean isone(boolean[] group) {
		Deque<Integer> q = new ArrayDeque<>();
		int i=0;
		while(i<n) {
			if (group[i]) {q.add(i); break;}
			i++;
		}
		boolean[] visit = new boolean[n];
		visit[i] = true;
		while (!q.isEmpty()) {
			int now = q.pop();
			for (int a=0; a<n; a++) { // 연결 그래프로 할걸
				if (g[now][a] && !visit[a] && group[a]) {q.add(a); visit[a] =true;} //방문한 적 없는 그룹내의 구역인 경우 q에 넣고 방문처리 
			}
		}
		for (int a=0; a<n; a++) if (group[a] && !visit[a]) return false; // 전부 같은 그룹에 있으면 true 아니면 false
		return true;
	}
}
