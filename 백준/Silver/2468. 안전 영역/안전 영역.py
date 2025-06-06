from collections import deque

N = int(input())
graph = []

max_h = 0
for i in range(N):
    arr = list(map(int, input().split()))
    graph.append(arr)
    max_h = max(max_h, max(arr))

def bfs(graph, visited, start_x, start_y, N, h):
    visited[start_y][start_x] = True
    q = deque([(start_x, start_y)])

    nx = [0, 0, -1, 1]
    ny = [-1, 1, 0, 0]

    while q:
        vx, vy = q.popleft()

        for i in range(4):
            x = vx + nx[i]
            y = vy + ny[i]

            if (x < 0 or x >= N or y < 0 or y >= N):
                continue

            if (graph[y][x] <= h):
                visited[y][x] = True

            if not visited[y][x]:
                visited[y][x] = True
                q.append((x, y))

    return 1

max_area = 0
for h in range(max_h+1):
    area = 0
    visited = [[False]*N for _ in range(N)]

    for i in range(N*N):
        y = i // N
        x = i % N

        if visited[y][x]:
            continue

        if graph[y][x] <= h:
            visited[y][x] = True
            continue

        area += bfs(graph, visited, x, y, N, h)

    max_area = max(max_area, area)

print(max_area)