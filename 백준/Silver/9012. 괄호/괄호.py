import math
import sys
input=sys.stdin.readline


T=int(input())
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
    if not VPS or stack:
        print("NO")
    else:
        print("YES")
            
