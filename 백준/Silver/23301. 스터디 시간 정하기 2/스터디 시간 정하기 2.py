N, T = map(int, input().split())

time = [[0 for _ in range(1000)] for _ in range(N)]

maxTime = 0

for i in range(N):
  K = int(input())
  
  for _ in range(K):
    start, end = map(int, input().split())
    time[i][start:end+1] = [1 for _ in range(end-start)]
    if (maxTime < end): maxTime = end

satisfaction = [0 for _ in range(maxTime-T+1)]

for i in range(maxTime-T+1):
  sum = 0
  for j in range(N):
    sum += time[j][i:i+T].count(1)
  satisfaction[i] = sum
  
startIdx = satisfaction.index(max(satisfaction))

print(startIdx, startIdx+T)