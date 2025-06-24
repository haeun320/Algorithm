from collections import deque

def bfs(graph, visited, node):
    q = deque([node])
    visited[node] = True
    
    while q:
        n = q.popleft()
        
        for i in graph[n]:
            if not visited[i]:
                visited[i] = True
                q.append(i)
                
    return 1
    
def make_graph(computers, n):
    graph = [[] for _ in range(n+1)]
    
    for i in range(n):
        for j in range(n):
            if computers[i][j] == 1 and i != j:
                graph[i+1].append(j+1)
                
    return graph

def solution(n, computers):
    visited = [False] * (n+1)
    graph = make_graph(computers, n)
    answer = 0
    
    for i in range(1, n+1):
        if not visited[i]:
            answer += bfs(graph, visited, i)
            
    return answer