# import sys
# sys.stdin = open("input.txt", "r")

N, M = map(int, input().split())
graph = [] # 바구니 격자
for i in range(N):
    graph.append(list(map(int, input().split())))

curCloud = [(N-1, 0), (N-1, 1), (N-2, 0), (N-2, 1)] # 현재 구름의 위치 배열 (y, x)

# 좌, 상, 우, 하 대각선 이동 정보: 1-based
dy = [0, 0, -1, -1, -1, 0, 1, 1, 1]
dx = [0, -1, -1, 0, 1, 1, 1, 0, -1]

def moveCloud(d, s):
    global curCloud
    for i in range(len(curCloud)):
        cy, cx = curCloud[i]
        y = (cy + dy[d] * s) % N
        x = (cx + dx[d] * s) % N
        curCloud[i] = (y, x)

def rain():
    for (y, x) in curCloud:
        graph[y][x] += 1

def duplicate():
    move = [2, 4, 6, 8] # 대각선 이동 정보 index

    for (y, x) in curCloud: # 물 복사 버그는 비가 내린 칸에만 해당!!
        # 현재 칸에 물 복사 버그 실행
        cnt = 0  # 대각선에 물 있는 바구니 수
        for i in range(4):
            ny = y + dy[move[i]]
            nx = x + dx[move[i]]

            # 범위 체크
            if ny < 0 or ny >= N or nx < 0 or nx >= N:
                continue

            if graph[ny][nx] > 0:
                cnt += 1

        graph[y][x] += cnt  # 현재 칸 cnt 만큼 증가


def makeNewCloud():
    global curCloud
    prevCloud = set(curCloud)
    curCloud = [] # 구름 모두 사라짐
    # graph 순회하면서 새 구름 생성
    for y in range(N):
        for x in range(N):
            if graph[y][x] >= 2 and (y, x) not in prevCloud:
                curCloud.append((y, x))
                graph[y][x] -= 2


def printForDebug():
    print("====================")
    for g in graph:
        print(g)
    print("====================")


# ======== main =============
for i in range(M):
    d, s = map(int, input().split())
    # 구름 이동 호출
    moveCloud(d, s)
    # print(f"cloud = {curCloud}")

    # 구름에서 비 내리기 호출
    rain()

    # 물 복사 버그 호출
    duplicate()

    # 새 구름 생성
    makeNewCloud()
    # printForDebug()


# graph 전체 요소 합 출력
s = 0
for g in graph:
    s += sum(g)
print(s)