import sys
input=sys.stdin.readline

dic={}

N,M=map(int,input().split())

for i in range(N):
    string=input()
    dic[string]=0
cnt=0
for _ in range(M):
    string=input()
    if string in dic:
        cnt+=1

print(cnt)
