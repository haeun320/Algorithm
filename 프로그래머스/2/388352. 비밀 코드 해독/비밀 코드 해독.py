from itertools import combinations

def solution(n, q, ans):
    combos = list(combinations(range(1, n+1), 5))
    for query, cnt in zip(q, ans):
        combos = [x for x in combos if len(set(query)&set(x)) == cnt]
    return len(combos)