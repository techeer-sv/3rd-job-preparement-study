import math

def primenumber(x):
    if x == 0 or x == 1:
        return False
    
    for i in range(2, int(math.sqrt(x) + 1)):
        if x % i == 0:
            return False
        
    return True	

def solution(n, k):
    answer = 0
    k_list = []
    
    while n >= k:
        i = n%k
        n = n//k
        k_list.append(i)
    k_list.append(n)
    k_list.reverse()
    
    cut = 0
    
    for i in k_list:
        if i == 0:
            if primenumber(cut):
                answer += 1
                cut = 0
                continue
            else:
                cut = 0
                continue        
            
        cut = 10 * cut + i
    
    if primenumber(cut):
        answer += 1
    
    return answer