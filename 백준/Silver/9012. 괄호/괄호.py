import math
import sys
input=sys.stdin.readline


T=int(input())

command=[]
for _ in range(T):
    VPS=True
    stack=[]
    ps=input().strip()
    for string in ps:
        if string =='(':
            stack.append('(')
        else:
            if stack:
                stack.pop()
            else:
                VPS=False
                break
    if VPS and not stack:
        print("YES")
    else:
        print("NO")
            
