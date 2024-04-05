import sys
input=sys.stdin.readline
#import queue
from collections import deque

def sequence(start):
    
    if len(ary)==m:
        print(' '.join(map(str,ary)))

    else:
        for i in range(start,n+1):
            if i not in ary:
                ary.append(i)
                sequence(i+1)
                ary.pop()


n,m=map(int,input().split())
ary=[]
sequence(1)
