N = int(input())

arr = []
for _ in range(N):
  arr.append(list(map(int, input().split())))
  
mindp = arr[0]
maxdp = arr[0]

for i in range(1, N):
  maxtmp = [0]*3
  mintmp = [0]*3
  
  maxtmp[0] = max(maxdp[:2]) + arr[i][0]
  mintmp[0] = min(mindp[:2]) + arr[i][0]
  
  maxtmp[1] = max(maxdp) + arr[i][1]
  mintmp[1] = min(mindp) + arr[i][1]
  
  maxtmp[2] = max(maxdp[1:]) + arr[i][2]
  mintmp[2] = min(mindp[1:]) + arr[i][2]
  
  maxdp = maxtmp
  mindp = mintmp
  
print(max(maxdp), min(mindp))