import sys
input=sys.stdin.readline
#import queue
from collections import deque

dq=deque()

N=int(input())

command=[]
for _ in range(N):
    command=[]
    command=list(input().split())
    if command[0] == 'push':
        dq.append(int(command[1]))
    elif command[0] == 'pop':
        if dq:    #값이 있을 경우
            print(dq.popleft())
        else:
            print(-1)
    elif command[0] == 'size':
        print(len(dq))
    elif command[0] == 'empty':
        if dq:
            print(0)
        else:
            print(1)
    elif command[0] == 'front':
        if dq:
            print(dq[0])
        else:
            print(-1)
    
    elif command[0] == 'back':
        if dq:
            print(dq[-1])
        else:
            print(-1)
    
    
