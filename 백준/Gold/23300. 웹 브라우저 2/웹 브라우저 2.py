# import sys
# sys.stdin = open("input.txt", "r")

N, Q = map(int, input().split())
backStack = []
forwardStack = []
curPage = -1

def goBack():
    global curPage

    if not backStack:
        return

    forwardStack.append(curPage)
    curPage = backStack.pop()

def goForward():
    global  curPage

    if not forwardStack:
        return

    backStack.append(curPage)
    curPage = forwardStack.pop()

def access(num):
    global curPage, forwardStack

    forwardStack = []

    if curPage < 0:
        curPage = num
        return

    backStack.append(curPage)
    curPage = num


def compress():
    global backStack
    if not backStack:
        return

    tmpBackStack = []

    for page in backStack:
        if not tmpBackStack or tmpBackStack[-1] != page:
            tmpBackStack.append(page)

    backStack = tmpBackStack


for _ in range(Q):
    request = input()
    # print(f"request = {request} =========")
    if request[0] == 'A':
        num = int(request[2:])
        access(num)

    elif request == 'B':
        goBack()

    elif request == 'F':
        goForward()

    elif request == 'C':
        compress()
    # print(f"curPage = {curPage}")
    # print(f"back = {backStack}")
    # print(f"forward = {forwardStack}")

print(curPage)

if not backStack:
    print(-1)
else:
    while backStack:
        print(backStack.pop(), end=" ")
    print()

if not forwardStack:
    print(-1)
else:
    while forwardStack:
        print(forwardStack.pop(), end=" ")
