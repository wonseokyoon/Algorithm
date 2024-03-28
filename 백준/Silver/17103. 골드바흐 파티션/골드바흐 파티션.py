import math
import sys
input=sys.stdin.readline


arr= [True for i in range(1000001)]
for i in range(2,1001):
    if arr[i]:
        for j in range(2*i,1000001,i):
            arr[j]=False


T=int(input())

for i in range(T):
    res=0
    N=int(input())

    for i in range(2,N//2+1):
        if arr[i] and arr[N-i]:
            res+=1
    print(res)