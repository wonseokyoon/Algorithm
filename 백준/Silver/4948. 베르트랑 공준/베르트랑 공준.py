import math
import sys
input=sys.stdin.readline

def is_prime(x):
    if x<2 : return False

    for i in range(2,int(math.sqrt(x))+1):
        if(x%i==0):
            return False
    return True

prime=[]
for i in range(2,2*123456):
    if is_prime(i):
        prime.append(i)

while(True):
    n=int(input())
    cnt=0
    
    if n==0 :
        break

    for i in prime:
        if n<i<=2*n:
            cnt+=1
    print(cnt)
        
