import sys
input=sys.stdin.readline
#import queue
from collections import deque


n,k=map(int,input().split())

deno =1    #분모
for i in range(n-k+1,n+1):
    deno *=i
for i in range(1,k+1):
    deno/=i
print(int(deno))
