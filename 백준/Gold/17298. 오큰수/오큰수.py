N = int(input())
A = list(map(int, input().split()))

NGE = [-1] * N
stack = [0]
for i in range(1, N):
  while(len(stack) > 0 and A[i] > A[stack[-1]]):
    NGE[stack.pop()] = A[i]
  stack.append(i)

print(*NGE)