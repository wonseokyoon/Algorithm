import sys
input=sys.stdin.readline
#import queue
from collections import deque

def sequence():

    if len(ary)==m:
        print(' '.join(map(str,ary)))

    for i in range(1,n+1):
        if i not in ary:
            ary.append(i)
            sequence()
            ary.pop()
            
    


n,m=map(int,input().split())
ary=[]
sequence()

