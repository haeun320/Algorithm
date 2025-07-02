from collections import deque

def print_building(building, L, R):
    print("======= building ========")
    for i in range(L):
        for j in range(R):
            print(building[i][j])
        print()
    print("=========================")

def solve():
    while True:
        L, R, C = map(int, input().split())

        if L == R == C == 0:
            break

        building = [[[] for _ in range(R)] for _ in range(L)]
        start_point = ()

        for i in range(L):
            for j in range(R):
                arr = list(input())
                building[i][j] = arr

                if 'S' in arr:
                    start_point = (i, j, arr.index('S'))
            input()

        def bfs(graph, start, visited):
            start_z, start_y, start_x = start

            q = deque([(start_z, start_y, start_x, 0)])
            visited[start_z][start_y][start_x] = True

            dz = [0, 0, 0, 0, -1, 1]
            dy = [-1, 1, 0, 0, 0, 0]
            dx = [0, 0, -1, 1, 0, 0]

            while q:
                nz, ny, nx, nl = q.popleft()

                for i in range(6):
                    z = dz[i] + nz
                    y = dy[i] + ny
                    x = dx[i] + nx

                    if x < 0 or y < 0 or z < 0 or x >= C or y >= R or z >= L:
                        continue

                    if not visited[z][y][x]:
                        visited[z][y][x] = True

                        if graph[z][y][x] == 'E':
                            return nl + 1

                        if graph[z][y][x] == '.':
                            q.append((z, y, x, nl+1))
            return -1

        visited = [[[False] * C for _ in range(R)] for _ in range(L)]
        m = bfs(building, start_point, visited)

        if m < 0:
            print("Trapped!")
        else:
            print(f"Escaped in {m} minute(s).")

solve()