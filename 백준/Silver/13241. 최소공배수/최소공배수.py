import math
import sys
input=sys.stdin.readline

def division(A,B):
    return math.gcd(A,B)

A,B=map(int,input().split())

res=division(A,B)

multi=A*B

print(multi//res)


