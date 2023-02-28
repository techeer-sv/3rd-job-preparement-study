# n = int(input())
# m = int(input())
# s = list(input())

# text = []

# for i in range(n+1):
#     text.append('I')
#     if n == i:
#         break
#     else:
#         text.append("O")

# check_cut = 0
# count = 0
# last = True
# find = [True] * len(s)
# idx = 0

# while last:
#     check_cut = count

#     for i in range(len(s)):
#         if s[i] == text[idx]:      
#             idx += 1
#             if idx == len(text) and find[i - idx]:
#                 count += 1
#                 find[i - idx] = False
#                 idx = 0
#                 break

#     if check_cut == count:
#         break     
       
# print(count)

n = int(input())
m = int(input())
s = list(input())

text = []

for i in range(n+1):
    text.append('I')
    if n == i:
        break
    else:
        text.append("O")

check_cut = 0
count = 0
last = True
find = [True] * len(s)
idx = 0

while True:
    check_cut = count

    for i in range(len(s)):
        if s[i] == text[idx]:      
            idx += 1
            if idx == len(text) and find[i - idx]:
                count += 1
                find[i - idx] = False
                idx = 0

    if check_cut == count:
        break     
       
print(count)