x = int(input())
d = [0] * (x + 1) # 메모이제이션


for i in range(2, x + 1):
    # 1 빼기, 횟수 더하기
    d[i] = d[i - 1] + 1
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3] + 1)
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
        
print(d[x])
