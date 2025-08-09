n = int(input())
pattern = input().split('*')

for i in range(n):
  s = input()
  
  if (len(s) < len(pattern[0]) + len(pattern[1])):
    print("NE")
    continue
  
  sidx = len(pattern[0])
  eidx = len(s) - len(pattern[1])
  
  if (s[:sidx] == pattern[0] and s[eidx:] == pattern[1]):
    print("DA")
  else:
    print("NE")