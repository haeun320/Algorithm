n = int(input())

d = [0] * 116
for i in range(3):
  d[i] = 1

for i in range(3, n):
  d[i] = d[i-1] + d[i-3]

print(d[n-1])