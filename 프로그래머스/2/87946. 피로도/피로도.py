from itertools import permutations

def solution(k, dungeons):
    perm = list(permutations(dungeons, len(dungeons)))
    result = 0
    
    for p in perm:
        # print(p)
        tmp = k
        cnt = 0
        for minm, cons in p:
            if tmp < minm:
                continue
            if tmp >= cons:
                tmp -= cons
                cnt += 1
        result = max(result, cnt)
        if result == len(dungeons):
            break
    
    return result
            