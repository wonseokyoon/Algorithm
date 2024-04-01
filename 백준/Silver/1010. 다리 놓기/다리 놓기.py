import sys
input=sys.stdin.readline
#import queue
from collections import deque

T=int(input())
for i in range(T):
    n,k=map(int,input().split())
    if k==0:
        print(0)
        continue
    if(k>n):
        tmp=n
        n=k
        k=tmp
    deno =1    #분모
    for i in range(n-k+1,n+1):
        deno *=i
    for i in range(1,k+1):
        deno//=i
    print(int(deno))
