n, m = map(int, input().split())

graph = []
count = 0

for i in range(m):
    graph.append(list(map(int, input().split())))

def dfs(x, y):
    nx = [0, 0, -1, 1]
    ny = [1, -1, 0, 0]
    
    for i in range(4):
        x += nx[i]
        y += ny[i]
        if 0 <= x < m and 0 <= y <n:
            if graph[x][y] == 0:
                dfs(x, y)
                return True

        return False
    
for i in range(n):
    for j in range(m):
        if dfs(i,j) == True:
            count+=1
        
print(count)