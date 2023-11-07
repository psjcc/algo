import java.io.*;
import java.util.*;
public class BOJ_2110_공유기설치 {
	static List<Integer> houses;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		houses = new ArrayList<>();
		for (int i=0; i<n; i++) houses.add(Integer.parseInt(br.readLine()));
		
		Collections.sort(houses); // 입력 받은후 집 거리순 정렬
		
		int lC=0, rC=(houses.get(houses.size()-1)-houses.get(0))/(C-1), mC=0;
		int lh; // C의 적절한 범위를 찾을건데요 (이제보니 변수가 이상하네요)
				// 아무튼 좌표가장 작은 집부터 가장 큰 집 거리 범위를 C-1로 나눈것이 최대거리입니다.
				// 그 범위를 lC, rC로 두고 mC를 통해 이분탐색하여 적절한 값을 찾겠습니다.
		while (lC<rC) {
			mC = (lC + rC+1)/2;
			lh=0; // lh ~ rh(n-1)을 두어 mC보다는 멀리 있는 가까운 집을 "다시 이분탐색"합니다.
			for (int i=0; i<C-2; i++) {
				if (lh ==n) {lh = n-1; break;}
				lh = bs(lh, n-1, houses.get(lh)+mC); // bs함수로 되어있고요
			}
			if (houses.get(n-1)-houses.get(lh)<mC) rC = mC-1; // 그리고 마지막 공유기를 둘 수없다면 mC의 좌측
			else lC = mC; // 마지막 공유기를 둘 수 있으면 mC의 우측을 탐색
		}
		System.out.println(lC);
	}
	
	static int bs(int l, int r, int x) {
		int m=l;
		while (l<r) {
			m = (l+r)/2;
			if (houses.get(m)<x) l = m+1;
			else r=m;
		}
		return l;
	}

}