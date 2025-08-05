from collections import deque

N = int(input())
area = []

for i in range(N):
    area.append(list(map(int, input().split())))

def bfs(visited, x, y, rain):
    visited[y][x] = True

    if area[y][x] <= rain:
        return 0
    
    q = deque([(x, y)])

    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]

    while q:
        x, y = q.popleft()

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]

            if nx < 0 or nx >= N or ny < 0 or ny >= N:
                continue

            if not visited[ny][nx]:
                visited[ny][nx] = True

                if area[ny][nx] > rain:
                    q.append((nx, ny))

    return 1

def solve():
    result = 0
    for rain in range(101):
        visited = [[False] * N for _ in range(N)]
        c = 0

        for y in range(N):
            for x in range(N):
                if visited[y][x]:
                    continue

                c += bfs(visited, x, y, rain)

        if c == 0:
            break

        result = max(result, c)

    return result

print(solve())