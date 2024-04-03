import sys
input=sys.stdin.readline
#import queue
from collections import deque


N,M=map(int,input().split())

dic={}
for i in range(N):
    string=input().strip()
    if len(string)<M:
        continue
    if string not in dic:
        dic[string]=1
    else:
        dic[string]+=1

sorted_dic=sorted(dic.items(), key=lambda x:(-x[1],-len(x[0]),x[0]))

for i in sorted_dic:
    print(i[0])

