def solution(people, limit):
    people.sort()
    print(people)
    p1 = 0
    p2 = len(people)-1
    
    cnt = 0
    while p1 <= p2:
        if people[p1] + people[p2] <= limit:
            p1 += 1
        p2 -= 1
        cnt += 1
    
    print(p1, p2)
    return cnt