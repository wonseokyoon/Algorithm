import sys
input=sys.stdin.readline
#import queue
from collections import deque


def fibo(n):
    global f1
    if n==1 or n==2:
        return 1
    else:
        f1+=1
        return (fibo(n-1)+fibo(n-2))

def fibonacci(n):
    global f2
    
    f[1]=1
    f[2]=1
    for i in range(3,n+1):
        f[i]=f[i-1]+f[i-2]
        f2+=1
    return f2


n=int(input())

f1,f2=1,0    # f1=1 시작 인 이유: n=1 or n=2 조건에 해당 할 시 else문이 실행되지 않기때문에
f=[0]*(n+1)
fibo(n)
fibonacci(n)
print(f1,f2,sep=' ')
