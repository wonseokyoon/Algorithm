import math

M=int(input())
N=int(input())

prime_list=[]

while(M<=N):

    if(M==1):
        M+=1
    else:
        
        prime=1
        Msqrt=int(math.sqrt(M))  #M의 제곱근
        for i in range(2,Msqrt+1):
            if(M%i==0):     #소수x
                prime=0
                break

        if(prime==1):       #소수일 경우
            prime_list.append(M)

        M+=1
    


sum=sum(prime_list)

if (len(prime_list)==0):
    print(-1)
else:
    print(sum)
    print(prime_list[0])

