import math
import sys
input=sys.stdin.readline

def gcd(x,y):
    return math.gcd(x,y)

T=int(input())
for i in range(T):
    A,B=map(int,input().split())
    res=A*B//gcd(A,B)
    print(res)
