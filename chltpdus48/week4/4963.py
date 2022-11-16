# 섬의 개수
import sys
sys.setrecursionlimit(10000) # -> 재귀함수가 만번이 될 때까지 임시로 허용해줌

def dfs(x, y):
    # 상하좌우 / 대각선 상좌, 상우, 하좌, 하우
    dx = [0, 0, -1, 1, -1, 1, -1, 1]
    dy = [1, -1, 0, 0, 1, 1, -1, -1]
    
    graph[x][y] = 0
    
    for i in range(8):
        rx = dx[i] + x
        ry = dy[i] + y
        if 0 <= rx < h and 0 <= ry < w:
            if graph[rx][ry] == 1:
                # if visited[rx][ry] == 0:
                dfs(rx, ry)

while True:
    graph = []
    
    # 지도의 너비 w와 높이 h
    w, h = map(int, input().split())
    
    if w == 0 and h == 0: # 입력 마지막 줄
        break
    
    for i in range(h):
        graph.append(list(map(int, input().split())))
    
    # visited = [[0] * w for _ in range(h)]
    count = 0
    
    for i in range(h):
        for j in range(w):
            if graph[i][j] == 1:
                dfs(i, j)
                count += 1
    
    print(count)