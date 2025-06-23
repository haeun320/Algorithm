from collections import deque

def bfs(maps, visited, m, n):
    q = deque([(0, 0, 0)]) # (x, y, level)
    visited[0][0] = True
    
    dy = [-1, 1, 0, 0]
    dx = [0, 0, -1, 1]
    
    min_level = 1e9
    is_arrived = False
    
    while (q):
        # print(f"queue = {q}")
        vx, vy, vl = q.popleft()
        
        for i in range(4):
            y = vy + dy[i]
            x = vx + dx[i]
            
            # print(f"x = {x}, y = {y}")
            
            if (x < 0 or x >= m or y < 0 or y >= n):
                continue
            
            if (maps[y][x] == 0):
                continue
                
            if not visited[y][x]:
                q.append((x, y, vl + 1))
                visited[y][x] = True
                
            if x == m-1 and y == n-1:
                min_level = min(min_level, vl + 1)
                is_arrived = True
                
    if is_arrived:
        return min_level + 1 # node 수 = level + 1
    
    return -1

def solution(maps):
    n = len(maps)
    m = len(maps[0])
    
    visited = [[False for _ in range(m)] for _ in range(n)]
    return bfs(maps, visited, m, n)
