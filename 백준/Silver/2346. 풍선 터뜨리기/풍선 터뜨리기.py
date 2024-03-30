import sys
input=sys.stdin.readline
#import queue
from collections import deque

N=int(input())
ans=[]
dq=deque(enumerate(map(int,input().split()),start=1))

circle=0
while circle<N:
    idx,element=dq.popleft()    #인덱스와 원소 값 같이 반
    ans.append(idx)

    if element>0:
        dq.rotate(-(element-1))
    else:
        dq.rotate(-element)   
    circle+=1

print(" ".join(map(str,ans)))
    
