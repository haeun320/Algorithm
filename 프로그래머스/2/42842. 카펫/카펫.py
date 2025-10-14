def solution(brown, yellow):
    x = round(((brown + 4) / 2) / 2)
    y = int(((brown + 4) / 2) - x)
    # print(x,y)
    while True:
        if (x-2)*(y-2) == yellow:
            return [x, y]
        x += 1
        y -= 1
    