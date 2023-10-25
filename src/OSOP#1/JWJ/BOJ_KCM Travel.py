import sys
from collections import deque

input = sys.stdin.readline
INF = sys.maxsize


def main():
    N, M, K = map(int, input().split())
    graph = [[] for _ in range(N + 1)]

    for _ in range(K):
        u, v, c, d = map(int, input().split())
        graph[u].append((v, c, d))

    dist = [[INF] * (M + 1) for _ in range(N + 1)]  # 각 공항에 가는데 드는 비용에 시간을 저장
    dist[1][0] = 0  # 1번을 0의 비용으로 가는데 걸리는 시간은 0으로 초기화
    que = deque([(0, 0, 1)])  # Time Cost Node

    while que:
        time, cost, node = que.popleft()

        if dist[node][cost] < time:  
            # 이미 저장된 시간 정보와 현재 목적지를 해당 비용으로 가는데 걸리는 시간을 비교해서 이미 최소라면(혹은 현재 시간보다는 작다면)
            continue  # 탐색할 필요 없음

        for city, c, t, in graph[node]:  # 해당 노드부터 연결된 노드들 탐색
            alt_c = cost + c
            alt_t = time + t

            if alt_c <= M and alt_t < dist[city][alt_c]:  # 계산된 비용이 예산 안이며 계산된 시간이 기록된 시간보다 적다면
                for i in range(alt_c, M + 1):  # 계산된 비용부터 최대 비용까지
                    if alt_t < dist[city][i]:  # 계산된 시간으로 갱신할 수 있다면 갱신
                        dist[city][i] = alt_t  # 예를 들어 비용 3으로 최소 시간으로 갈 수 있다면 이후 노드들은 비용을 더 들여도 최소 시간으로 갈 수 있다고 가정
                    else:  
                        break  # 계산된 비용보다 더 적은 시점에서는 갱신하면 정보가 훼손되므로 종료
                que.append((alt_t, alt_c, city))  # 그게 아니라면 다음 탐색을 위해 저장

    sol = dist[N][M]  # 목적지의 최대 예산에 저장된 시간을 출력

    print(sol if sol != INF else 'Poor KCM')  # 위 과정에서 목적지를 최대 비용을 사용했을 때 도달못했다면 INF임


for ___ in range(int(input())):
    main()