N, K = map(int, input().split())

# dp[i][j] = i번째 짐을 최대 j 무게까지 버틸 수 있는 가방에 넣을 때의 최대 가치
dp = [[0]*(K+1) for _ in range(N+1)] 

for i in range(1, N+1):
  w, v = map(int, input().split())
  
  for j in range(1, K+1):
    dp[i][j] = dp[i-1][j]
    
    if w <= j:
      dp[i][j] = max(dp[i-1][j], dp[i-1][j-w] + v)
      
print(max(dp[-1]))