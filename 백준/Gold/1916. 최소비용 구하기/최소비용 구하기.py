from heapq import heappop, heappush

N = int(input())
M = int(input()) 

# 도시번호 1~N 
graph = [[] for _ in range(N+1)] # graph[i] = (j, k): i번째 도시에서 출발해 j번째 도시까지 가는데 비용 k
dist = [1e9] * (N+1) # dist[i]: i번째 도시까지 가는 최소비용

for i in range(M):
  depart, arrive, fare = map(int, input().split())
  graph[depart].append((arrive, fare))
  
d, a = map(int, input().split())
  
def dijkstra(start):
  q = []
  heappush(q, (0, start)) # (비용, 출발 도시)
  dist[start] = 0
  
  while q:
    fare, depart = heappop(q)
    
    if dist[depart] < fare: # 저장된 비용이 더 작음 -> 이미 방문한 도시
      continue
    
    for arrive, cost in graph[depart]: # 연결된 모든 도시 탐색
      if fare + cost < dist[arrive]: # 현재 저장된 도착 도시 최소 비용보다 작을 때
        dist[arrive] = fare + cost
        heappush(q, (dist[arrive], arrive)) # 다음 단계에서 현재 도시를 출발점으로하는 다음 도시 탐색을 위해 arrive 추가
    
dijkstra(d)
print(dist[a])