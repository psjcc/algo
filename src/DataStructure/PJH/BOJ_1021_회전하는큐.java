import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_1021_회전하는큐 {
	static int N, M;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		LinkedList<Integer> list = new LinkedList<>();
		st = new StringTokenizer(br.readLine(), " ");
		//배열에 1부터 N까지 저장
		for(int i = 1;i<=N;i++) {
			list.offer(i);
		}
		
		//첫 인덱스 0과 회전 수 cnt
		int idx = 0;
		int cnt = 0;
		
		//M개의 입력
		for(int i = 0;i<M;i++) {
			//입력받은 수 n과 n의 인덱스 저장
			int n = Integer.parseInt(st.nextToken());
			int nIdx = list.indexOf(n);
			
			//범위를 벗어나지 않게 큰 값에서 작은 값 빼기
			int diff1 = Math.max(idx, nIdx) - Math.min(idx, nIdx);
			
			//0부터 작은값과의 거리와 끝부터 큰 값과의 거리의 합 => 큐를 반대방향으로 회전한 경우
			int diff2 = (list.size()-Math.max(idx, nIdx))+Math.min(idx, nIdx);
			//둘 중 최솟값을 카운팅
			cnt+=Math.min(diff1, diff2);
			idx = nIdx;
			list.remove(nIdx);
			
		}
		System.out.println(cnt);
	}
}
