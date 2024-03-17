N=int(input())

for i in range(1,N+1):
    digit_sum=i+sum(map(int,str(i)))   #실제 숫자 + 각자리수의 합

    if(digit_sum==N):
        print(i)
        break
    if(i==N):
        print(0)
