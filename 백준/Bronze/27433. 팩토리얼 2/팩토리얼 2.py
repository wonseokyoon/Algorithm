import sys
input=sys.stdin.readline
#import queue
from collections import deque


n=int(input())
multi=1
for i in range(1,n+1):
    multi*=i
print(multi)
