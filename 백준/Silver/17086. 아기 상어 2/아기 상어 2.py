from collections import deque
# import sys
# sys.stdin = open("input.txt", "r")

N, M = map(int, input().split())
graph = []
for _ in range(N):
    arr = list(map(int, input().split()))
    graph.append(arr)

def bfs(y, x):
    visited = [[False for _ in range(M)] for _ in range(N)]
    q = deque([(y,x,0)]) # (y, x, level)
    visited[y][x] = True

    dy = [-1, -1, 0, 1, 1, 1, 0, -1]
    dx = [0, 1, 1, 1, 0, -1, -1, -1]

    while q:
        vy, vx, vl = q.popleft()

        for i in range(8):
            ny = vy + dy[i]
            nx = vx + dx[i]

            if ny < 0 or ny >= N or nx < 0 or nx >= M:
                continue

            if graph[ny][nx] == 1:
                return vl + 1

            if not visited[ny][nx]:
                q.append((ny, nx, vl+1))
                visited[ny][nx] = True

    return -1

# ==== main ====
result = -1
for y in range(N):
    for x in range(M):
        if graph[y][x] != 1:
            result = max(result, bfs(y, x))

print(result)

