# 어렵다...!

def solution(N, number):
    answer = -1
    dp = []
    
    for i in range(1, 9):
        numbers = set()
        numbers.add(int(str(N)*i))
        
        for j in range(i-1):
            for x in dp[j]:
                for y in dp[-j-1]:
                    numbers.add(x+y)
                    numbers.add(x-y)
                    numbers.add(x*y)
                    if y != 0:
                        numbers.add(x/y)
                        
        if number in numbers:
            answer = i
            break
        
        dp.append(numbers)
        
    return answer