import math

N, M = map(int, input().split())

result = M - math.gcd(N, M)
print(result)