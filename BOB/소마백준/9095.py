n = int(input())
test_list = [ 0 for i in range(n)]

for i in range(n):
    test_list[i] = int(input())
    
cut_list = [0 for i in range(11)]

cut_list[1] = 1
cut_list[2] = 2
cut_list[3] = 4

for i in range(4, 11):
    cut_list[i] = cut_list[i - 1] + cut_list[i - 2] + cut_list[i - 3]

for i in test_list:
    print(cut_list[i])