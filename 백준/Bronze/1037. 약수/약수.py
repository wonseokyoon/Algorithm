import sys
input=sys.stdin.readline
#import queue
from collections import deque

T=int(input())

num=[]
num=list(map(int,input().split()))
num.sort()
res=num[0]*num[-1]
print(res)
