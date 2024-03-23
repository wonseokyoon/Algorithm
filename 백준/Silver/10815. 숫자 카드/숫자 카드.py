import sys
input=sys.stdin.readline

N_list=[]
M_list=[]

N=int(input())
N_list=list(map(int,input().split()))      # 6 3 2 10 -10
M=int(input())
M_list=list(map(int,input().split()))      # 10 9 -5 2 3 4 5 -10

dic={}
for i in N_list:
    dic[i]=0                               #dic 배열 0으로 초기화

for i in M_list:
    if i in dic:
        print(1,end=' ')
    else:
        print(0,end=' ')
