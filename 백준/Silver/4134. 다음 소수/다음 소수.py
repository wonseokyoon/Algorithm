import math
import sys
input=sys.stdin.readline

def is_prime(x):
    if(x<2): return 0
    for i in range(2,int(math.sqrt(x))+1):
        if(x%i==0):
            return 0
    return 1

T=int(input())

for i in range(T):
    N=int(input())
    while True:
        if(is_prime(N)==1):
             print(N)
             break
        else:
            N+=1


        
