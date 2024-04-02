import sys
input=sys.stdin.readline
#import queue
from collections import deque

T=int(input())

names={}
names["ChongChong"]=1

for i in range(T):
    
    string=input().split()
    if string[0] not in names:
        names[string[0]]=0
    if string[1] not in names:
        names[string[1]]=0

    if names[string[0]]==1:
        names[string[1]]=1
    elif names[string[1]]==1:
        names[string[0]]=1


    
cnt=0
for name in names:
    if names[name]==1:
        cnt+=1
print(cnt)
