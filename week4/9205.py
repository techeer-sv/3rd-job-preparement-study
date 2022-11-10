# 맥주 마시면서 걸어가기
from collections import deque

#테스트 케이스 t
t = int(input())

def bfs(x, y):
    queue = deque()
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        if abs(ex - x) + abs(ey - y) <= 1000:
            return "happy"
        for i in range(n):
            if not visited[i]:
                new_x, new_y  = conv[i]
                if abs(x - new_x) + abs(y - new_y) <= 1000:
                    visited[i] = 1
                    queue.append((new_x, new_y))
    return "sad"


for _ in range(t):
    # 맥주를 파는 편의점의 개수 n
    n = int(input())
    
    # 상근이네 집 좌표
    sx, sy = map(int, input().split())
    
    # 편의점 좌표
    conv = [list(map(int, input().split())) for _ in range(n)]
    
    # 펜타포트 락 페스티벌 좌표
    ex, ey = map(int, input().split())
    
    # 방문 노드
    visited = [0 for _ in range(n)]
    
    print(bfs(sx, sy))
    