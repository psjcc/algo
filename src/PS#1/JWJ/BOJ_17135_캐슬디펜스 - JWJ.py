# 남의 코드 - 미안

import sys

input = sys.stdin.readline
from collections import deque
from itertools import combinations

N, M, D = map(int, input().split())

gird = [list(map(int, input().split())) for _ in range(N)]
dy = [0, -1, 0]
dx = [-1, 0, 1]
answer = 0

archor_pos = list(combinations([i for i in range(M)], 3))

def kill(archor):
    temp_gird = [line[:] for line in gird]  # 전체 슬라이싱을 해서 복사하지 않으면 원본 리스트가 훼손됨
    killed = [[0] * M for _ in range(N)]
    result = 0
    # 적군 움직이는 턴 (한칸씩 내려가는거를 for문을 반대로 돌리는 거로 생각)
    for ay in range(N - 1, -1, -1):
        # 이번턴 죽는 애(궁수들이 한번에 공격하니까)
        this_turn = []
        for ax in archor:  # 각 궁수별로 bfs 돌리면서 사정거리 안 제일 가까운 적군 찾기
            dq = deque([(ay, ax, 1)])   # 첫 값은 궁수 바로 위 칸으로 넣어줌
            while dq:
                y, x, d = dq.popleft()
                if temp_gird[y][x] == 1:
                    this_turn.append((y, x))  
                    # 자연스러운 흐름상 쏠 수 있는 궁수의 좌표를 넣어주는 것이 맞지만 여러 궁수가 동일한 적을 처치하는 상황에서
                    # 한 번만 처리하고 나머지는 공격할 수 없는 상황이라 간주하면 중복되는 좌표 처리를 방지할 수 있음
                    if killed[y][x] == 0:  # 여러 궁수가 동일한 적을 처치했을 때 따로 카운트 되는 것을 방지
                        killed[y][x] = 1
                        result += 1
                    break  # 맵에 적을 발견하면 무조건 종료, 설령 죽인 상태라고해도 나중에 일괄처리해야 하므로 반영이 안 돼있을 수 있음
                if d < D:
                    for di in range(3):
                        ny = y + dy[di]
                        nx = x + dx[di]
                        if 0 <= ny < N and 0 <= nx < M:
                            dq.append((ny, nx, d + 1))

        for y, x in this_turn:
            temp_gird[y][x] = 0  # 한 턴에 공격한 애들 한번에 죽이기

    return result

for a in archor_pos:
    answer = max(answer, kill(a))

print(answer)