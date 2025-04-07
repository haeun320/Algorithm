N, T = map(int, input().split())

time = [0 for _ in range(1000)]

for i in range(N):
  K = int(input())
  
  for _ in range(K):
    start, end = map(int, input().split())
    for idx in range(start, end):
      time[idx] += 1

satisfaction = [0 for _ in range(1000-T+1)]

for i in range(1000-T+1):
  satisfaction[i] = sum(time[i:i+T])
  
startIdx = satisfaction.index(max(satisfaction))
print(startIdx, startIdx+T)