from collections import deque

n, m = map(int, input().split())

paper = []
for _ in range(n):
    paper.append(list(map(int, input().split())))

def solve(paper, n, m):
    def bfs(x, y, visited):
        q = deque([(x, y)])
        visited[y][x] = True
        area = 1

        dy = [-1, 1, 0, 0]
        dx = [0, 0, -1, 1]

        while q:
            nx, ny = q.popleft()

            for i in range(4):
                x = nx + dx[i]
                y = ny + dy[i]

                if x < 0 or x >= m or y < 0 or y >= n:
                    continue

                if not visited[y][x]:
                    visited[y][x] = True

                    if paper[y][x] == 1:
                        q.append((x, y))
                        area += 1

        return area

    visited = [[False] * m for _ in range(n)]
    count = 0
    max_area = 0

    for i in range(n):
        for j in range(m):
            if not visited[i][j] and paper[i][j] == 1:
                area = bfs(j, i, visited)
                count += 1
                max_area = max(max_area, area)

    print(count)
    print(max_area)

solve(paper, n, m)