import sys
input=sys.stdin.readline
#import queue
from collections import deque


n=int(input())
flist=[]
flist.append(0)
flist.append(1)
if n==0:
    print(0)
else:

    for i in range(2,n+1):
        flist.append(flist[i-1]+flist[i-2])

    print(flist[-1])
