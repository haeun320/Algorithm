from collections import deque

N, M = map(int, input().split())
maze = [list(map(int, input())) for _ in range(N)]

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(x, y):
    q = deque()
    q.append((x,y))

    while q:
        vx, vy = q.popleft()

        for i in range(4):
            nx = vx + dx[i]
            ny = vy + dy[i]

            if (nx < 0 or nx >= M or ny < 0 or ny >= N):
                continue
            elif (maze[ny][nx] == 0):
                continue
            elif (maze[ny][nx] == 1):
                maze[ny][nx] = maze[vy][vx] + 1
                q.append((nx, ny))

    return maze[N - 1][M - 1]

print(bfs(0,0))