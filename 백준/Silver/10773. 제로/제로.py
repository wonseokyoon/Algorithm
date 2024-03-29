import math
import sys
input=sys.stdin.readline


stack=[]
stack.append(0)
k=int(input())
for _ in range(k):
    n=int(input())
    if n==0:
        stack.pop()
    else:
        stack.append(n)



sum=0
for i in stack:
    sum+=i

print(sum)

