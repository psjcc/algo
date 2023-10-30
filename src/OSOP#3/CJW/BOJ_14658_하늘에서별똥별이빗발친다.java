import java.io.*;
import java.util.*;
public class BOJ_14658_하늘에서별똥별이빗발친다 {
	static List<int[]> stars;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		stars = new ArrayList<>();
		int x, y;
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			stars.add(new int[] {x, y});
		} // 입력완료

		int ans=0, t;
		for (int[] star:stars) { // 모든 별을 돌면서
			x = star[0]; y = star[1];
			for (int i=0; i<=l; i++) { // x좌표를 한 변에 둔 모든 트램펄린 탐색
				ans = Math.max(ans, check(x, y-i, l));
			}
		}
		System.out.println(k-ans);
		// 시간복잡도 박살났음
	}
	
	/** 별 갯수 세는 함수입니다. x y >> 트램펄린 왼쪽 아래 모서리 좌표, l>>트램펄린 길이 */
	static int check(int x, int y, int l) {
		int t=0;
		for (int[] c:stars) {
			if (x<=c[0] && c[0]<=x+l && y<=c[1] && c[1]<=y+l) t++;
		}
		return t;
	}

}