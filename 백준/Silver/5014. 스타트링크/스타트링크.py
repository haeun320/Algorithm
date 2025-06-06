from collections import deque

F, S, G, U, D = map(int, input().split())

def solution(F, S, G, U, D):
    # 엘리베이터 이용 불가
    k = G - S
    if (k > 0 and U == 0):
        print("use the stairs")
        return

    if (k < 0 and D == 0):
        print("use the stairs")
        return

    q = deque([(S, 0)]) # (value, level)
    memo = set()

    while q:
        v, l = q.popleft()
        
        if (v == G):
            print(l)
            return

        left_child = v - D
        right_child = v + U
        child_level = l + 1

        if left_child > 0 and left_child <= F and left_child not in memo:
            q.append((left_child, child_level))
            memo.add(left_child)

        if right_child > 0 and right_child <= F and right_child not in memo:
            q.append((right_child, child_level))
            memo.add(right_child)

    print("use the stairs")
    return

solution(F, S, G, U, D)