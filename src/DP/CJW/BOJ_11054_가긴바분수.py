import sys; input= sys.stdin.readline

def solve(N, A):
    dp1= [1] * N
    for i in range(N-1):
        for j in range(i+1,N):
            if A[i] < A[j]:
                if dp1[j] < (s1 := dp1[i] + 1):
                    dp1[j] = s1
    dp2= [1] * N
    for i in range(N-1,0,-1):
        for j in range(i-1,-1,-1):
            if A[i] < A[j]:
                if dp2[j] < (s3 := dp2[i] + 1):
                    dp2[j] = s3
    ans = -1
    for i in range(N):
        if ans < (s := dp1[i] + dp2[i] - 1):
            ans = s
    return ans

N = int(input())
A = list(map(int, input().split()))
print(solve(N,A))