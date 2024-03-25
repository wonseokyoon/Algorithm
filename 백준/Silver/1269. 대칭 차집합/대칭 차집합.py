import sys
input=sys.stdin.readline

A,B=map(int,input().split())

a_list=list(map(int,input().split()))
b_list=list(map(int,input().split()))

a_b={}  #a-b
b_a={}  #b-a
for i in a_list:
    a_b[i]=0
for i in b_list:
    b_a[i]=0

a_cnt=0
b_cnt=0
for i in b_list:
    if i in a_b:
        a_cnt+=1

for i in a_list:
    if i in b_a:
        b_cnt+=1

print(A+B-a_cnt-b_cnt)

