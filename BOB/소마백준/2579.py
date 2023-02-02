n = int(input())
list_step = [0 for i in range(301)]
d = [0 for i in range(301)]

for i in range(n):
    list_step[i] = int(input())

d[0] = list_step[0]
d[1] = list_step[0] + list_step[1]
d[2] = max(list_step[1] + list_step[2], list_step[0] + list_step[2])

for i in range(3, n):
    d[i] = max(d[i - 3] + list_step[i - 1] + list_step[i], d[i - 2] + list_step[i])
    
print(d[n - 1])
