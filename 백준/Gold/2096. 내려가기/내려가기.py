N = int(input())

maxdp = list(map(int, input().split()))
mindp = maxdp[:] # 얕은복사 (슬라이싱은 새로운 리스트를 생성함)

for _ in range(N-1):
  arr = list(map(int, input().split()))
  
  maxdp = [
    max(maxdp[:2]) + arr[0],
    max(maxdp) + arr[1],
    max(maxdp[1:]) + arr[2]
  ]
  
  mindp = [
    min(mindp[:2]) + arr[0],
    min(mindp) + arr[1],
    min(mindp[1:]) + arr[2]
  ]
  
print(max(maxdp), min(mindp))