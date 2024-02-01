import sys
input = sys.stdin.readline

N = int(input().rstrip())
li = []

for i in range(N):
  age, name = input().split()
  li.append([int(age), name])

li = sorted(li, key = lambda x:x[0])
for age, name in li:
  print(age, name)