import sys
input=sys.stdin.readline
#import queue
from collections import deque

N=int(input())

a_list=list(map(int,input().split()))
b_list=list(map(int,input().split()))
m=int(input())
c_list=list(map(int,input().split()))

dq=deque()

for i in range(N):
    if a_list[i] ==0:
        dq.append(b_list[i])    #1 4

for i in range(m):
    dq.appendleft(c_list[i])        #7 4 2 1 4
    print(dq.pop(),end=" ")
     
