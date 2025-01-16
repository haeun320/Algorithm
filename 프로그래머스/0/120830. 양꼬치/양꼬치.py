def solution(n, k):
    service = n // 10
    return n * 12000 + (k - service) * 2000