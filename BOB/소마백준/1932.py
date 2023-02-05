n = int(input())
dp = []

for i in range(n):
    dp.append(list(map(int, input().split())))

# dp[1][0] = dp[0][0] + dp[1][0]
# dp[1][1] = dp[0][0] + dp[1][1]
# dp[2][0] = dp[1][0] + dp[2][0]
# dp[2][1] = max(dp[1][0], dp[1][1]) + dp[2][1]
# dp[2][2] = dp[1][1] + dp[2][2]

for i in range(1, n):
    for j in range(i + 1):
        if j == 0:
            dp[i][j] = dp[i-1][j] + dp[i][j]
        elif j == i:
            dp[i][j] = dp[i-1][j-1] + dp[i][j]
        else:
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + dp[i][j]

print(max(dp[n-1]))