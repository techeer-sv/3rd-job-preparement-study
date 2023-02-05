n, m = map(int, input().split())

s = []
visited = [False] * (n + 1)

def dfs(start):
    if len(s) == m:
        print(' '.join(map(str, s)))
        return
    for i in range(start, n+1):
        if visited[i]:
            continue
        visited[i] = True
        s.append(i)
        dfs(i+1)
        s.pop()
        visited[i] = False
        
dfs(1)