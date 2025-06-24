from collections import deque

def solution(n, computers):
    def bfs(start):
        q = deque([start])
        visited[start] = True

        while q:
            node = q.popleft()

            for i in range(n):
                if not visited[i] and computers[node][i] == 1 and i != node:
                    q.append(i)
                    visited[i] = True

        return 1

    visited = [False] * n
    answer = 0
    
    for i in range(n):
        if not visited[i]:
            answer += bfs(i)
            
    return answer