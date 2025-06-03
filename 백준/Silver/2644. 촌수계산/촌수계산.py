from collections import deque

n = int(input())
start, end = map(int, input().split())
m = int(input())

graph = [[] * (n+1) for _ in range(n+1)]

for i in range(m):
    x, y = map(int, input().split())
    graph[x].append(y)
    graph[y].append(x)

visited = [False] * (n+1)

def bfs(graph, visited, start, end):
    q = deque([(start, 0)]) #(node, level)
    visited[start] = True

    while q:
        node, level = q.popleft()
        for i in graph[node]:
            if not visited[i]:
                if (i == end):
                    return level + 1
                q.append((i, level +1))
                visited[i] = True

    return -1

print(bfs(graph, visited, start, end))