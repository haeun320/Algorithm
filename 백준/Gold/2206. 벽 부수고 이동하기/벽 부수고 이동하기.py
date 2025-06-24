from collections import deque

# import sys
# sys.stdin = open('input.txt', 'r')

N, M = map(int, input().split())

matrix = []

for i in range(N):
    arr = list(map(int, input()))
    matrix.append(arr)

def solve(N, M, matrix):
    # visited[y][x][0]: 벽을 부수지 않고 도달
    # visited[y][x][1]: 벽을 부수고 도달
    visited = [[[False] * 2 for _ in range(M)] for _ in range(N)]

    q = deque([(0, 0, 0, False)]) # x, y, level, is_broken
    visited[0][0][0] = True

    dy = [-1, 1, 0 , 0]
    dx = [0, 0, -1, 1]

    while q:
        nx, ny, nl, nb = q.popleft()

        # 목표 지점 도달 시 즉시 반환 (BFS이므로 첫 도달이 최단거리)
        if nx == M - 1 and ny == N - 1:
            return nl + 1  # 노드 수 = 레벨 + 1

        for i in range(4):
            x = nx + dx[i]
            y = ny + dy[i]

            if x < 0 or x >= M or y < 0 or y >= N:
                continue

            # 벽을 아직 부수지 않은 상태
            if not nb:
                if matrix[y][x] == 0 and not visited[y][x][0]:
                    # 빈 칸으로 이동
                    visited[y][x][0] = True
                    q.append((x, y, nl + 1, False))
                elif matrix[y][x] == 1 and not visited[y][x][1]:
                    # 벽을 부수고 이동
                    visited[y][x][1] = True
                    q.append((x, y, nl + 1, True))
            
            # 벽을 이미 부순 상태
            else:
                if matrix[y][x] == 0 and not visited[y][x][1]:
                    # 빈 칸으로만 이동 가능 (더 이상 벽을 부술 수 없음)
                    visited[y][x][1] = True
                    q.append((x, y, nl + 1, True))

    return -1
    
print(solve(N, M, matrix))