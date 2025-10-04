N = int(input())
arr = list(map(int, input().split()))

dp = [1] * N

for i in range(1, N):
  tmp = []
  for j in range(i):
    if arr[i] > arr[j]:
      tmp.append(dp[j])
      
  if tmp:
    dp[i] = max(tmp) + 1
  
print(max(dp))