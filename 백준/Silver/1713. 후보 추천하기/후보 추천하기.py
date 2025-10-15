N = int(input()) # 사진 틀 개수
T = int(input()) # 전체 학생의 총 추천 횟수
student = list(map(int, input().split())) # 추천받은 학생 번호
frame = dict()

for s in student:
  # print(f"frame={frame}")
  if s in frame:
    frame[s] += 1
    continue

  if len(frame) < N:
    frame[s] = 1
    continue
  
  k = min(frame, key=frame.get)
  frame.pop(k)
  frame[s] = 1

# print(f"frame={frame}")
result = [x[0] for x in sorted(frame.items())]

print(" ".join(map(str, result)))