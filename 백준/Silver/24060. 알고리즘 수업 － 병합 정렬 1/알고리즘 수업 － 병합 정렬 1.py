import sys
input=sys.stdin.readline
#import queue
from collections import deque


def merge_sort(ary,p,r):
    cnt=0
    if p<r:
        q=(p+r)//2
        merge_sort(ary,p,q)
        merge_sort(ary,q+1,r)
        merge(ary,p,q,r)
        
def merge(ary,p,q,r):
    global cnt,res
    i=p
    j=q+1
    tmp=[]
    while i<=q and j<=r:
        if ary[i]<=ary[j]:
            tmp.append(ary[i])
            i+=1
        else:
            tmp.append(ary[j])
            j+=1
    while i<=q:
        tmp.append(ary[i])
        i+=1
    while j<=r:
        tmp.append(ary[j])
        j+=1
    i=p
    t=0
    while(i<=r):
        ary[i]=tmp[t]
        cnt+=1
        if cnt==K:
            res=ary[i]
            break;
        i+=1
        t+=1

N,K=map(int,input().split())
ary=list(map(int,input().split()))
res=-1
cnt=0
merge_sort(ary,0,N-1)
print(res)

