import sys
input=sys.stdin.readline
#import queue
from collections import deque

N=int(input())

dq=deque()
for _ in range(N):
    command=list(input().split())

    match command[0],bool(dq): #True:있음, False: 없음
        case '1', _:
            dq.appendleft(int(command[1]))
        case '2', _:
            dq.append(int(command[1]))
        case '3', True:
            print(dq.popleft())
        case '3', False:
            print(-1)
        case '4', True:
            print(dq.pop())
        case '4', False:
            print(-1)
        case '5', _:
            print(len(dq))
        case '6', True:
            print(0)
        case '6', False:
            print(1)
        case '7', True:
            print(dq[0])
        case '7', False:
            print(-1)
        case '8', True:
            print(dq[-1])
        case '8', False:
            print(-1)

    
