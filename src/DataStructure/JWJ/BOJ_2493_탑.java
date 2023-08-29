package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

// input 길이가 꽤 큼. 50만개 입력
// Scanner, BufferedReader 경우의 차이가 큼
// output도 크다 -> StringBuilder 사용
// 자료구조 = 모두 다 담고 왔다갔다 하는 배열 -> 불필요한 자료는 제거하는 stack;
public class boj_2493 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Deque<int[]> tower = new ArrayDeque<>();
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 1; i < n + 1; i++) {
			int height = Integer.parseInt(st.nextToken());

			// stack에서 현재 높이보다 작은 애들은 제거, 큰 것이 나오면 그 큰 것의 번호를 출력에 추가
			while (!tower.isEmpty()) {
				// 현재 가장 높은 타워가 방금 들어온 타워보다 높을 경우
				if (tower.peek()[1] >= height) {
					sb.append(tower.peek()[0]).append(" ");  // 현재 가장 높은 타워 추가
					break;
				}
				tower.pop(); // height 보다 작으면 제거, 즉 마지막 타워보다 큰 타워가 오면 해당 타워만 고려되므로 이전 타워들을 제거
			}
			// 내가 제일 높으면
			if(tower.isEmpty())  //결과 출력용
				sb.append("0 ");
			tower.push(new int[] { i, height });  // 새로 들어온 탑에 대한 정보 저장
		}
		System.out.println(sb);
	}
}
