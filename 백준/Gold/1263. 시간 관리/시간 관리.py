N = int(input())

task = []
for _ in range(N):
  T, S = map(int, input().split()) # 처리 시간, 마감 시간
  task.append((T, S))

task.sort(key=lambda x: x[1], reverse=True)

curTime = task[0][1]

for t, s in task:
  curTime = min(curTime, s)
  curTime -= t

if curTime < 0:
  print(-1)
else:
  print(curTime)