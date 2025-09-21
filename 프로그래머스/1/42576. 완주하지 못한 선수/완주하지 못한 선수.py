def solution(participant, completion):
    person = {}
    for p in participant:
        if person.get(p):
            person[p] += 1
        else:
            person[p] = 1
            
    for c in completion:
        if person.get(c):
            person[c] -= 1
            
    for p, n in person.items():
        if n != 0:
            return p
            
    return ''