import java.util.;
import java.io.;
public class BOJ_1863_스카이라인쉬운거 {
	static char[][] map;
	static boolean[][][] check = new boolean[9][9][10];
	static Dequeint[] stack = new ArrayDeque();
	static boolean flag;
	public static void main(String[] args)throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int ans=0, y; // ans초기화, 사용할 y 선언

		DequeInteger q = new ArrayDeque(); // stack이라 읽는다
		q.add(0); // q.isEmpty 대신 0인지 확인할 수 있었어요
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); // x 버리고
			y = Integer.parseInt(st.nextToken()); // y받아서 검사
			if (q.peekLast()<y) { // 더 높은 건물을 만나면 하나 추가해야함
				ans++;
				q.add(y);
			}else { // 낮은 건물이 나타날 때
				while (q.size()>0 && q.peekLast()>y) q.pollLast(); // 지금보다 높은건물 다 빼주고
				if (q.peekLast() == y) continue; // 이전에 있던 건물이랑 높이 같으면 같은건물입니다
				ans++; // 아니라면 새로운 건물입니다.
				q.add(y);
			}
		}
		System.out.println(ans);
	}main
}