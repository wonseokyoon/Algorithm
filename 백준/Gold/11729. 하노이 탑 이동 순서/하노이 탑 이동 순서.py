import sys
input=sys.stdin.readline
#import queue
from collections import deque

def hanoi(n,start,end):
    cnt=0
    if n==1:
        print(start,end)
        cnt+=1
        return

    hanoi(n-1,start,6-start-end)    #n-1개의 원판을 1번에서 2번으로 이동
    print(start,end)    #맨 밑 원판을 1번에서 3번으로 이동
    hanoi(n-1,6-end-start,end)  #나머지 원판들을 3번으로 이동         




n=int(input())
print(2**n-1)
hanoi(n,1,3)
