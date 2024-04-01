import sys
input=sys.stdin.readline
#import queue
from collections import deque

T=int(input())

names={}
cnt=0
for i in range(T):
    string=input().rstrip()
    if string!='ENTER':
        if string not in names:
            names[string]=1
    else:
        for key in names:
            if names[key]==1:
                cnt+=1
        names={}
                
for key in names:
    if names[key]==1:
        cnt+=1
        
print(cnt)
