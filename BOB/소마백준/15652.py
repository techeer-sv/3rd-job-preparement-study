n, m = map(int, input().split())

s = []

def dfs():
    if len(s) == m:
        print(' '.join(map(str, s)))
        return
    for i in range(1, n + 1):
        if len(s) != 0 and i < s[- 1]:
            continue
        s.append(i)
        dfs()
        s.pop()
        
dfs()