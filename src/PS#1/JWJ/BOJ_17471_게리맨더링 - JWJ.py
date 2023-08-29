import sys, itertools
from collections import deque, defaultdict

def bfs(district):
    start = district[0]  # 시작하는 지역구
    q = deque([start])
    visited = {start}
    population_sum = 0
    while q:
        v = q.popleft()  # 지역구의 정보를 가져와서
        population_sum += population[v]  # 해당 지역구의 인구수 누적
        for d in graph[v]:  # 인접 지역 확인
            if d in district and d not in visited:  # 해당 지역이 선거구에 속하며 아직 방문하지 않았다면
                q.append(d)  # 다음 탐색을 위해 저장
                visited.add(d)  # 방문처리, 큐에서 빼자마자 무작정 방문 처리를 하면 선거구가 아닌 지역도 방문처리 됨
    return population_sum, len(visited)

n = int(sys.stdin.readline().strip())
population = [int(x) for x in sys.stdin.readline().split()]  # 지역별 인구수
graph = defaultdict(list)  # 그래프 -> 인접리스트
result = float('inf')  # 최소값을 갱신해 나가기 때문에 초기 비교값을 무한으로 설정

for i in range(n):
    district_info = [int(x) for x in sys.stdin.readline().split()]  # 지역별 정보
    for j in range(1, district_info[0] + 1):  # 0번 인덱스는 인접한 지역의 수이므로 인접한 지역 정보들이 있는 1번부터 입력
        graph[i].append(district_info[j] - 1)  # 문제에서는 노드의 인덱스 1이지만 코드에서는 0으로 설정했기 때문에 -1하여 인덱스 맞춤

for i in range(1, n//2 + 1):  # 모든 조합을 다 볼 필요없음 -> a구역의 조합의 나머지는 자연스럽게 b구역이 되기 때문 -> 중복 회피
    comb = list(itertools.combinations(range(n), i))  # 조합을 통해 뽑는 수는 1부터 되야하므로 1부터 시작
    for ci in comb:  # 각 조합에 따라
        apopulation_sum, a_visit = bfs(ci)  # 뽑힌 조합
        bpopulation_sum, b_visit = bfs([i for i in range(n) if i not in ci])  # 0 ~ n의 지역구 중 뽑히지 않은 지역
        if a_visit + b_visit == n:  # 각 지역의 탐색 결과를 합쳤을 때 모든 지역구를 다 탐색했다면
            result = min(result, abs(apopulation_sum - bpopulation_sum))  # 차이의 최소값 갱신

print(result if result != float('inf') else - 1)  # 차이가 갱신되지 않았다면(제약을 벗어났다면) -1 아니라면 답 출력
