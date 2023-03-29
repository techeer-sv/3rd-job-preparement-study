# def solution(board, skill):
#     answer = 0
#     # [type, r1, c1, r2, c2, degree]
#     # type이 1일 경우는 적의 공격
#     # type이 2일 경우는 아군의 회복 스킬
    
#     for i in skill:
#         r1, c1 = i[1], i[2]
#         r2, c2 = i[3], i[4]
#         for j in range(r1, r2 + 1):
#             for k in range(c1, c2 + 1):
#                 if i[0] == 1:
#                     board[j][k] -= i[5]
#                 else:
#                     board[j][k] += i[5]

#     for i in board:
#         for j in i:
#             if j > 0:
#                 answer += 1
                
#     return answer

def solution(board, skill):
    answer = 0
    tmp = [[0] * (len(board[0]) + 1) for _ in range(len(board) + 1)] # 누적합 기록을 위한 배열
 
    for type, r1, c1, r2, c2, degree in skill:
        # 누적합 기록, 부호에 주의할 것
        tmp[r1][c1] += degree if type == 2 else -degree
        tmp[r1][c2 + 1] += -degree if type == 2 else degree
        tmp[r2 + 1][c1] += -degree if type == 2 else degree
        tmp[r2 + 1][c2 + 1] += degree if type == 2 else -degree

    # 행 기준 누적합
    for i in range(len(tmp) - 1):
        for j in range(len(tmp[0]) - 1):
            tmp[i][j + 1] += tmp[i][j]

    # 열 기준 누적합
    for j in range(len(tmp[0]) - 1):
        for i in range(len(tmp) - 1):
            tmp[i + 1][j] += tmp[i][j]

    # 기존 배열과 합함
    for i in range(len(board)):
        for j in range(len(board[i])):
            board[i][j] += tmp[i][j]
            # board에 값이 1이상인 경우 answer++
            if board[i][j] > 0: answer += 1

    return answer