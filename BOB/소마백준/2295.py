# 메모리 초과 ㅋㅋ...

n = int(input())
u = []

for i in range(n):
    u.append(int(input()))
 
group = set()

for i in range(n-1):
    for j in range(n-1):
        for k in range(n-1):
            if i == j or j == k or i == k:
                continue
            else:
                group.add((u[i], u[j], u[k]))

plus_value = 0
k = 0

for i in group:
    plus_value = 0
    for j in i:
        plus_value += j
        for z in range(3, len(u)):
            if plus_value == u[z] and u[z] > k:
                k = u[z]
            
print(k)