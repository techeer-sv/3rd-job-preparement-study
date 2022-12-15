import sys

input = sys.stdin.readline

n = int(input())

graph = [[] for _ in range(n+1)]
answer = []

for i in range(1, n+1):
    graph[i].append(int(input()))
    
def dfs(number):
    if visited[number] == False:
        visited[number] = True
        for a in graph[number]:
            tmp_up.add(number)
            tmp_bottom.add(a)
            if tmp_up == tmp_bottom:
                answer.extend(list(tmp_bottom))
                return
            
            dfs(a)
            
    visited[number] = False

for i in range(1, n + 1):
    visited = [False] * (n + 1)
    tmp_up = set()
    tmp_bottom = set()

    dfs(i)

answer = list(set(answer))
answer.sort()

print(len(answer))
for a in answer:
    print(a)