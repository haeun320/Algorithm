import sys

N = int(sys.stdin.readline().rstrip())
time = list(map(int, sys.stdin.readline().split()))
time.sort()

sum_time = [time[0]] * N
for i in range(1, N):
  sum_time[i] = sum_time[i-1] + time[i]
  
print(sum(sum_time))