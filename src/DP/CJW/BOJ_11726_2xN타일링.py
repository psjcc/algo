from collections import deque
n=int(input())
if n==1:
    print(1)
elif n==2:
    print(2)
else: 
    dp=deque(maxlen=2)
    dp.append(1)
    dp.append(2)
    for i in range(3,n+1):
        dp.append((dp[0]+dp[1])%10007)
    print(dp[1])