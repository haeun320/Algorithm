from bisect import bisect_left, bisect_right

def solution(citations):
    citations.sort()
    n = len(citations)
    # print(citations)
    h = 0
    for i in range(n+1):
        upCnt = n - bisect_left(citations, i)
        dwnCnt = bisect_left(citations, i)
        if upCnt >= i and dwnCnt <= i:
            h = i
        # print(f"i={i}, up={upCnt}, down={dwnCnt}, h={h}")
    
    return h