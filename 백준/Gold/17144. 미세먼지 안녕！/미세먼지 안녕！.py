import math
# import sys
# sys.stdin = open("input.txt", "r")

R, C, T = map(int, input().split())
graph = []
cleaner = [] # 공기청정기 행
for i in range(R):
    arr = list(map(int, input().split()))
    graph.append(arr)
    if arr[0] == -1:
        cleaner.append(i)

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

def isOutOfRange(r, c):
    """격자 바깥이거나 공기청정기 위라면 False"""
    if r < 0 or r >= R or c < 0 or c >= C:
        return True
    if graph[r][c] == -1:
        return True
    return False

def spreadDust():
    """미세먼지 확산 - graph 변경"""
    global graph
    tmpGraph = [[0 for _ in range(C)] for _ in range(R)]
    for r in range(R):
        for c in range(C):
            if graph[r][c] > 0:
                dust = graph[r][c]
                spread = math.floor(dust/5)

                for i in range(4):
                    nr = r + dr[i]
                    nc = c + dc[i]
                    if isOutOfRange(nr, nc):
                        continue
                    tmpGraph[nr][nc] += spread
                    dust -= spread

                tmpGraph[r][c] += dust

    for r in range(R):
        for c in range(C):
            if graph[r][c] != -1:
                graph[r][c] = tmpGraph[r][c]


def cleanerOn():
    """공기청정기 작동, 바람으로 순환"""
    # 위쪽 순환
    p = cleaner[0]
    r = p - 1
    c = 0
    while r > 0:
        graph[r][c] = graph[r-1][c]
        r -= 1
    while c < C - 1:
        graph[r][c] = graph[r][c+1]
        c += 1
    while r < p :
        graph[r][c] = graph[r+1][c]
        r += 1
    while c > 1:
        graph[r][c] = graph[r][c-1]
        c -= 1
    graph[r][c] = 0


    # 아래쪽 순환
    p = cleaner[1]
    r = p + 1
    c = 0
    while r < R - 1:
        graph[r][c] = graph[r+1][c]
        r += 1
    while c < C - 1:
        graph[r][c] = graph[r][c+1]
        c += 1
    while r > p:
        graph[r][c] = graph[r-1][c]
        r -= 1
    while c > 1:
        graph[r][c] = graph[r][c-1]
        c -= 1
    graph[r][c] = 0


def sumDust():
    s = 0
    for r in range(R):
        s += sum(graph[r])
    return  s + 2

def printForDebug(graph):
    print("================")
    for r in graph:
        print(r)
    print("================")

# ============ main =================
for i in range(T):
    spreadDust()
    cleanerOn()
    # printForDebug(graph)

print(sumDust())