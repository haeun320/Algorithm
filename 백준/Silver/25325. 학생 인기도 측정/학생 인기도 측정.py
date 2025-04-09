N = int(input())

students = list(input().split())
popularity = dict(zip(students, [0 for _ in range(len(students))]))

for _ in range(N):
  likes = list(input().split())
  
  for like in likes:
    popularity[like] += 1
    
popularity = dict(sorted(popularity.items(), key = lambda x:(-x[1], x[0])))

for key, value in popularity.items():
  print(key, value)