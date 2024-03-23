import sys
input=sys.stdin.readline

N_list=[]
M_list=[]

N=int(input())
N_list=list(map(int,input().split()))      # 6 3 2 10 -10
M=int(input())
M_list=list(map(int,input().split()))      # 10 9 -5 2 3 4 5 -10

dic={}
for i in range(N):
    dic[N_list[i]]=0
    #dic={ 10:1, 9:0, -5:0, 2:1, 3:1, 4:0, 5:0, -10:0 }

for i in M_list:
    if i in dic:
        print(1,end=' ')
    else:
        print(0,end=' ')