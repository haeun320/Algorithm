N, M = map(int, input().split())
p = []

for _ in range(M):
  p.append(int(input()))
  
maxProfit = 0
price = 0

for i in range(M):
  count = len(list(filter(lambda x : x >= p[i], p)))
  profit = count * p[i] if (count <= N) else N * p[i]
  
  if (profit > maxProfit):
    maxProfit = profit
    price = p[i]
    
print(price, maxProfit)