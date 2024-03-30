import sys
input=sys.stdin.readline
#import queue
from collections import deque

N=int(input())
dq=deque()
for num in range(1,N+1):
    dq.append(num)    # 1 2 3 4 5 6

while len(dq)>1:
    dq.popleft()        #맨 위 카드 제거
    dq.append(dq[0])    #그 다음 위에있던 카드 맨 아래로
    dq.popleft()

print(dq[0])
    
    
    
