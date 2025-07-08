s = input()
li = [0 for i in range(26)]

for i in s:
  n = ord(i) - ord("z") - 1
  li[n] += 1
  
for i in li:
  print(i, end=" ")