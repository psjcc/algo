import sys
N=int(input())
A=[0 for _ in range(N+2)]
for i in range(1,N+1):
    A[i]=int(sys.stdin.readline())
DP=[[0,0] for _ in range(N+2)]
DP[1][0]=A[1]
DP[2][0]=A[2]
for i in range(1,N):
    if i+1<=N:DP[i+1][1]=max(DP[i+1][0],DP[i][0]+A[i+1])
    if i+2<=N:DP[i+2][0]=max(DP[i+2][0],DP[i][0]+A[i+2],DP[i][1]+A[i+2])
print(max(DP[N][0],DP[N][1]))