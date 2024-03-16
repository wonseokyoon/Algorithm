a,b,c=map(int,input().split())

sum=a+b+c
max_len=max(a,b,c)      #최대 길이
dis_len=sum-max_len     #나머지 길이 합

if(max_len<dis_len):
    print(sum)
else:
    max_len=dis_len-1
    sum=max_len+dis_len
    print(sum)
