def solve(n, m):
    result_arr = [0] * 8
    num_used = [False] * 9 # 1 ~ 8 숫자 사용 여부

    def back_tracking(digit):
        if digit == m:
            for i in range(m):
                print(result_arr[i], end=' ')
            print()
            return
        
        for i in range(1, n+1):
            if not num_used[i]:
                result_arr[digit] = i
                num_used[i] = True
                back_tracking(digit + 1)
                num_used[i] = False

    back_tracking(0)

n, m = map(int, input().split())
solve(n, m)