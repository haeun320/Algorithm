from collections import deque

def visited_index(x, y, N):
    return N * y + x

def bfs(graph, visited, start_x, start_y, N, h):
    if graph[start_y][start_x] <= h:
        visited[visited_index(start_x, start_y, N)] = True
        return 0

    nx = [0, 0, -1, 1]
    ny = [-1, 1, 0, 0]

    q = deque([(start_x, start_y)])
    visited[visited_index(start_x, start_y, N)] = True

    while q:
        vx, vy = q.popleft()

        for i in range(4):
            x = vx + nx[i]
            y = vy + ny[i]

            if x < 0 or x >= N or y < 0 or y >= N:
                continue

            visited_idx = visited_index(x, y, N)

            if graph[y][x] <= h:
                visited[visited_idx] = True
                continue

            if not visited[visited_idx]:
                q.append((x, y))
                visited[visited_idx] = True

    return 1

def solve(N, graph):
    max_height = 0
    for row in graph:
        max_height = max(max_height, max(row))

    max_region = 0
    for h in range(0, max_height+1):
        visited = [False] * (N ** 2)
        region = 0

        for idx in range(N ** 2):
            if visited[idx]:
                continue

            y = idx // N
            x = idx % N
            if graph[y][x] > h:
                region += bfs(graph, visited, x, y, N, h)

        max_region = max(max_region, region)

    return max_region

N = int(input())
graph = [list(map(int, input().split())) for _ in range(N)]

print(solve(N, graph))
