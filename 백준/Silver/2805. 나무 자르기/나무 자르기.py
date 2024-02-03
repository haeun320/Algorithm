import sys
input = sys.stdin.readline

N, M = map(int, input().split())
height = list(map(int, input().split()))

start = 0
end = max(height)

rst = 0
while(start <= end):
  H = (start + end) // 2
  
  sum = 0
  for i in height:
    if i > H:
      sum += i - H
      
  if sum < M:
    end = H - 1
  else:
    rst = H
    start = H + 1
    
print(rst)