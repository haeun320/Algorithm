# import sys
# sys.stdin = open("input.txt", "r")

from collections import deque

N = int(input())
graph = []
# 상어 위치 초기화
sy = 0
sx = 0
ssize = 2
eatCnt = 0
totalTime = 0
curTime = 0

def bfs():
    global sx, sy, curTime
    visited = [[False for _ in range(N)] for _ in range(N)]
    q = deque([(sy, sx, 0)]) # (y, x, level)
    visited[sy][sx] = True

    # 상, 좌, 우, 하 순서 탐색
    # dy = [-1, 1, 0, 0]
    # dx = [0, 0, -1, 1]
    dy = [-1, 0, 0, 1]
    dx = [0, -1, 1, 0]
    prevLevel = 0

    while q:
        # 현재 큐가 다음 레벨로 이루어져 있을때
        if prevLevel != q[0][2]:
            prevLevel = q[0][2]
            li = sorted(list(q))
            # 가장 위, 왼쪽의 먹을 수 있는 물고기
            for ny, nx, nl in li:
                if graph[ny][nx] < ssize and graph[ny][nx] != 0:
                    sy = ny
                    sx = nx
                    curTime = nl
                    return True

        vy, vx, vl = q.popleft()

        for i in range(4):
            ny = vy + dy[i]
            nx = vx + dx[i]

            if ny < 0 or ny >= N or nx < 0 or nx >= N:
                continue

            if not visited[ny][nx]:
                # print(f"graph = {graph[ny][nx]}")
                if graph[ny][nx] <= ssize:
                    q.append((ny, nx, vl+1))
                    visited[ny][nx] = True
                    #
                    # if graph[ny][nx] < ssize and graph[ny][nx] != 0:
                    #     sy = ny
                    #     sx = nx
                    #     curTime = vl + 1
                    #
                    #     return True
    return False



# 먹을 수 있는 물고기 찾기
def findFish():
    global totalTime, eatCnt, ssize, curTime

    # printForDebug(graph)
    graph[sy][sx] = 0
    while bfs():
        totalTime += curTime
        eatCnt += 1

        # temp
        # graph[sy][sx] = 9
        # printForDebug(graph)
        # temp

        graph[sy][sx] = 0
        if eatCnt == ssize:
            ssize += 1
            # print(f"size = {ssize}")
            eatCnt = 0
        time = 0


    return totalTime


def printForDebug(graph):
    print("==================")
    for i in range(N):
        print(graph[i])
    print("==================")

# =========== main =============
for i in range(N):
    li = list(map(int, input().split()))
    graph.append(li)
    for j in range(N):
        if li[j] == 9:
            sy = i
            sx = j
print(findFish())