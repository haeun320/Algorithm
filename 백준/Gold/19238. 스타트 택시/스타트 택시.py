# import sys
# sys.stdin = open("input.txt", "r")

from collections import deque

N, M, gas = map(int, input().split())
graph = []
for _ in range(N):
    graph.append(list(map(int, input().split())))

taxi = list(map(int, input().split())) # [r, c]
for i in range(2):
    taxi[i] -= 1 # 0-based로 변경

customer = []
for _ in range(M):
    customer.append(list(map(int, input().split()))) # [출발지 r, c, 목적지 r, c]
curCustomer = -1 # 현재 손님 번호 1-based 양수

dr = [-1, 1, 0, 0]
dc = [0, 0, -1, 1]

def isOutOfRange(r, c):
    """범위 밖이거나 벽이면 True 반환"""
    if r < 0 or r >= N or c < 0 or c >= N:
        return True
    if graph[r][c] == 1:
        return True
    return False


def findCustomer(r, c):
    """손님 태우러 갈 수 있으면 True, 아니면 False 반환
    택시 위치와 연료는 global로 처리"""
    global graph, gas, curCustomer
    visited = [[False for _ in range(N)] for _ in range(N)]
    q = deque([(r, c, 0)])  # (행, 열, 레벨)
    visited[r][c] = True

    candidates = []  # (거리, 행, 열, 승객번호) 저장할 리스트
    min_distance = float('inf')

    while q:
        nr, nc, nl = q.popleft()

        # 이미 더 가까운 거리의 승객을 찾았다면 더 이상 탐색하지 않음
        if nl > min_distance:
            break

        if graph[nr][nc] < 0:  # 승객 찾음
            customer_num = -graph[nr][nc]
            if nl < min_distance:
                # 더 가까운 거리의 승객 발견 - 기존 후보들 초기화
                min_distance = nl
                candidates = [(nl, nr, nc, customer_num)]
            elif nl == min_distance:
                # 같은 거리의 승객 추가
                candidates.append((nl, nr, nc, customer_num))

        # 아직 최단 거리보다 짧거나 같은 거리라면 계속 탐색
        if nl < min_distance:
            for i in range(4):
                vr = nr + dr[i]
                vc = nc + dc[i]
                if isOutOfRange(vr, vc):
                    continue

                if not visited[vr][vc]:
                    q.append((vr, vc, nl + 1))
                    visited[vr][vc] = True

    # 승객을 찾지 못한 경우
    if not candidates:
        return False

    # 우선순위에 따라 정렬: 거리 -> 행번호 -> 열번호 순
    candidates.sort()

    # 가장 우선순위가 높은 승객 선택
    distance, selected_r, selected_c, customer_num = candidates[0]

    # 연료 체크
    if gas <= distance:
        return False

    # 택시 이동 및 승객 태우기
    gas -= distance
    taxi[0] = selected_r
    taxi[1] = selected_c
    curCustomer = customer_num
    graph[selected_r][selected_c] = 0  # 손님 태우고 빈 칸으로 처리

    return True


def moveTaxi(r, c, arriveR, arriveC):
    global gas, taxi
    visited = [[False for _ in range(N)] for _ in range(N)]
    q = deque([(r, c, 0)]) # (행, 열, 레벨)
    visited[r][c] = True

    while q:
        nr, nc, nl = q.popleft()
        if nr == arriveR and nc == arriveC:
            if gas < nl:
                return False
            gas += nl # - 소모량 + (소모량 * 2) = + 소모량
            taxi[0] = nr
            taxi[1] = nc
            return True

        for i in range(4):
            vr = nr + dr[i]
            vc = nc + dc[i]
            if isOutOfRange(vr, vc):
                continue

            if not visited[vr][vc]:
                q.append((vr, vc, nl+1))
                visited[vr][vc] = True

    return False

# ========== main ================
def solve():
    global gas, taxi, graph
    for i in range(len(customer)):
        graph[customer[i][0]-1][customer[i][1]-1] = -(i+1) # 승객 위치 표시. 벽과의 혼동 방지를 위해 1-based 음수 처리

    # print(gas)
    for i in range(len(customer)):
        # 승객 찾기
        if not findCustomer(taxi[0], taxi[1]):
            return -1
        # print("============")
        # print(f"customer = {curCustomer}, taxi = {taxi}, gas = {gas}")
        # 승객 목적지로 이동
        idx = curCustomer - 1 # 1-based에서 0-based로 변환
        if not moveTaxi(taxi[0], taxi[1], customer[idx][2]-1, customer[idx][3]-1):
            return -1
        # print(f"customer = {curCustomer}, taxi = {taxi}, gas = {gas}")

    return gas

print(solve())
