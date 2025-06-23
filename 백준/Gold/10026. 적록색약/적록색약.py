from collections import deque
import copy

def is_same_area_for_blind(current, previous):
    same_color = ["R", "G"]

    if current in same_color and previous in same_color:
        return True

    return False

def bfs(graph, x, y, N, is_blind):
    visited = [[False] * N for _ in range(N)]

    q = deque([(x, y)])
    visited[y][x] = True
    color = graph[y][x]
    graph[y][x] = "X"

    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]

    while q:
        vx, vy = q.popleft()

        for i in range(4):
            x = vx + dx[i]
            y = vy + dy[i]

            if x < 0 or x >= N or y < 0 or y >= N:
                continue

            if not visited[y][x]:
                visited[y][x] = True

                if graph[y][x] == color:
                    q.append((x, y))
                    graph[y][x] = "X"

                elif is_blind and is_same_area_for_blind(graph[y][x], color):
                    q.append((x, y))
                    graph[y][x] = "X"

    return 1

def print_graph(graph, N): # for debug
    print("======== graph =========")
    for i in range(N):
        print(graph[i])
    print("========================")

N = int(input())
normal = []
blind = []

for _ in range(N):
    row = list(input())
    normal.append(copy.deepcopy(row))
    blind.append(copy.deepcopy(row))

normal_area = 0
blind_area = 0

for i in range(N):
    for j in range(N):
        if normal[i][j] != "X":
            normal_area += bfs(normal, j, i, N, False)
            # print_graph(normal, N)

        if blind[i][j] != "X":
            blind_area += bfs(blind, j, i, N, True)
            # print_graph(blind, N)

print(normal_area, blind_area)