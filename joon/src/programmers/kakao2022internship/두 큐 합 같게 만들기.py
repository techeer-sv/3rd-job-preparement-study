from collections import deque

def solution(queue1, queue2):
    #     적은 큐에서 큰 큐로 이동
    #     반복을 중단 하는 경우 : 같아질때, 전체 큐 크기의 3배 돌렸을떄?

    q1 = deque(queue1)
    q2 = deque(queue2)

    s1 = sum(q1)
    s2 = sum(q2)

    index = 0

    if (s1 + s2) % 2 == 1:
        return -1

    while len(queue1) * 4 > index:
        if s1 > s2:
            temp = q1.popleft()
            q2.append(temp)
            s1 -= temp
            s2 += temp
        elif s2 > s1:
            temp = q2.popleft()
            q1.append(temp)
            s2 -= temp
            s1 += temp
        else:
            return index

        index += 1

    return -1