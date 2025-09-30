import heapq

T = int(input())
for t in range(T):
  minheap = []
  maxheap = []
  
  k = int(input())
  visited = [False for _ in range(k)]
  
  for i in range(k):
    op, n = input().split()
    n = int(n)
    
    if op == "I":
      heapq.heappush(minheap, (n, i))
      heapq.heappush(maxheap, (-n, i))
      visited[i] = True # 현재 명령어 id를 True로 표시(True -> Inserted)
      
    else:
      if n == 1: # 최댓값 삭제
        while maxheap and not visited[maxheap[0][1]]: # 동기화. not visited -> Deleted
          heapq.heappop(maxheap)
        if maxheap: # 삭제
          visited[maxheap[0][1]] = False # visited에 Deleted로 마킹
          heapq.heappop(maxheap)
        
        
      elif n == -1: # 최솟값 삭제
        while minheap and not visited[minheap[0][1]]: # 동기화
          heapq.heappop(minheap)
        if minheap:
          visited[minheap[0][1]] = False
          heapq.heappop(minheap)
      
  # 최종 정리 (양쪽 동기화)
  while minheap and not visited[minheap[0][1]]:
      heapq.heappop(minheap)
  while maxheap and not visited[maxheap[0][1]]:
      heapq.heappop(maxheap)
  
  if not minheap or not maxheap:
      print("EMPTY")
  else:
      print(-maxheap[0][0], minheap[0][0])