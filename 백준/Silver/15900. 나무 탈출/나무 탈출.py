from collections import deque

N = int(input())

adjacency_list = [[] for _ in range(N+1)]

for i in range(N-1):
    a, b = map(int, input().split())
    adjacency_list[a].append(b)
    adjacency_list[b].append(a)

visited = [False] * (N+1)
edges = 0

q = deque([(1, 0)])
visited[1] = True

while q:
    v, l = q.popleft()

    is_node = True

    for n in adjacency_list[v]:
        if not visited[n]:
            q.append((n, l+1))
            visited[n] = True
            is_node = False
    
    if is_node:
        edges += l

if edges % 2 == 0:
    print("No")
else:
    print("Yes")