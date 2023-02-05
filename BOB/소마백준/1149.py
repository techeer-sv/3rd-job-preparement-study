n = int(input())
dp = [] 

for i in range(n):
    dp.append(list(map(int, input().split())))
        
# home[i][0]: 빨강, home[i][1]: 초록, home[i][2]: 파랑

for i in range(1, len(dp)):
    dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + dp[i][0]
    dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + dp[i][1]
    dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + dp[i][2]
    
print(min(dp[n - 1]))