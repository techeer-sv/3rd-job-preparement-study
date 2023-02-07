n = int(input())
s = []

for i in range(n):
    s.append(list(input()))

score = 0
total = 0

for i in range(len(s)):
    for j in s[i]:
        if j == 'O':
            score += 1
            total += score
        if j == 'X':
            score = 0
    print(total)
    total = 0
    score = 0