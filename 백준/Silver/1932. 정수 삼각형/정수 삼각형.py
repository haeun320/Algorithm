n = int(input())
arr = []
for i in range(n):
  arr.append(list(map(int, input().split())))
  
dp = arr[0] # 이전 열까지의 합 (길이: 이전 열 요소 개수)

# 현재 열의 i번째 요소가 봐야하는 dp는 dp[i-1], dp[i]
def Dp(row):
  global dp
  curr = []
  for i in range(len(arr[row])):
    c = 0
    if i-1 >= 0:
      c = dp[i-1] + arr[row][i]
    if i < len(arr[row]) - 1:
      c = max(c, dp[i]+arr[row][i])
    curr.append(c)
  dp = curr
  
for i in range(1, n):
  Dp(i)
  
print(max(dp))