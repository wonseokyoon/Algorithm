import sys
input=sys.stdin.readline
#import queue
from collections import deque


N=int(input())
fact=1
for i in range(1,N+1):
    fact*=i
print(fact)
