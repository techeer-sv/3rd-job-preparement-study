n = int(input())
u = []

for i in range(n):
    u.append(int(input()))
 
group = set()

# x+y = k-z

for i in range(n-1):
    for j in range(n-1):
        group.add(u[i] + u[j])
        
k = 0

for i in range(n-1, -1, -1):
    for j in range(i+1):
        if u[i] - u[j] in group and u[i] > k:
            k = u[i]
            break
        
print(k)