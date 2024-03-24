import sys
input=sys.stdin.readline

N,M=map(int,input().split())

N_list=[]
M_list=[]
dict={}
for i in range(N):
    string=input().strip()
    N_list.append(string)
N_list.sort()
for i in N_list:
    dict[i]=0

for i in range(M):
    string=input().strip()
    M_list.append(string)
    
cnt=0
for i in M_list:
    if i in dict:
        dict[i]=1
        cnt+=1

print(cnt)
for i in dict:
    if dict[i]==1:
        print(i)

    
