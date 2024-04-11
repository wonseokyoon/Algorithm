import sys
input=sys.stdin.readline
#import queue
#from collections import deque

def binary(N):
    dp=[0]*(N+1)
    if(N==1): return 1
    dp[1]=1
    dp[2]=2
    for i in range(3,N+1):
        dp[i]=(dp[i-1]+dp[i-2])%15746
    return dp[N]

N=int(input())
print(binary(N))
