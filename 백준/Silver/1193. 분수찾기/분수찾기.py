X=int(input())

sum=0
n=0
while(sum<X):
    sum+=n
    n+=1

n-=1

order=X-(sum-n)     #n번째 행의 몇번째 숫자인지(1번째 ~ n번째)

if(n%2==0):     #n이 짝수
    x=n-order
    y=order-1

else:
    x=order-1
    y=n-order



ans=str(y+1)+"/"+str(x+1)
print(ans)

