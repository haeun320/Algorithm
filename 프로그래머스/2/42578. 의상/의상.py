def solution(clothes):
    N = len(clothes)
    dict = {}
    
    for v,k in clothes:
        if dict.get(k):
            dict[k] += 1
            continue
        dict[k] = 1
    
    result = 1
    for v in dict.values():
        result *= (v+1)
    
    return result - 1
