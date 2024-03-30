import sys
input=sys.stdin.readline
#import queue
from collections import deque

n,k=map(int,input().split())

dq=deque()
for i in range(1,n+1):
    dq.append(i)    #1 2 3 4 5 6 7

res=[]
while len(dq)>0:
    for _ in range(k-1):
        dq.append(dq.popleft())
    res.append(dq.popleft())

print('<',end="")
print(", ".join(str(num) for num in res),end='')
print('>')
