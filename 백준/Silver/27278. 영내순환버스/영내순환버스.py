N, M = map(int, input().split())

busStopDurations = list(map(int, input().split()))
prefix = [0] # 누적합 배열

for i in range(1, N+1):
  prefix.append(prefix[i-1] + busStopDurations[i-1])
  
cycle = sum(busStopDurations)
maxArriveTime = 0

for _ in range(M):
  p, r, c = map(int, input().split()) # 승차 지점, 하차 지점, 버스를 기다리기 시작한 시각
  
  # 버스 탑승 시각
  if (c % cycle <= prefix[p-1]):
    depart = (c // cycle) * cycle + prefix[p-1]
  else:
    depart = (c // cycle + 1) * cycle + prefix[p-1]
    
  # 버스 하차 시각
  duration = prefix[r-1] - prefix[p-1]
  arrive = duration + depart if (duration > 0) else duration + depart + cycle
  
  if (maxArriveTime < arrive):
    maxArriveTime = arrive
    
print(maxArriveTime)

