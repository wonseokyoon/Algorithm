import sys
input=sys.stdin.readline
#import queue
from collections import deque

def recursion(s,l,r,cnt):
    cnt+=1
    if l>=r:
        return 1,cnt
    elif s[l] != s[r]:
        return 0,cnt
    else:
        return recursion(s,l+1,r-1,cnt)
    

def isPalindrome(s):
    res,cnt=recursion(s,0,len(s)-1,0)
    return res,cnt


t=int(input())

for i in range(t):
    string=input().strip()
    res,cnt=isPalindrome(string)
    print(res,cnt,sep=" ")
