import sys
input=sys.stdin.readline

N=int(input())

dic={}
for i in range(N):
    name,log=input().split()
    dic[name]=log

sorted_dic=sorted(dic.items(),key=lambda item:item[0],reverse=True)
for item in sorted_dic:
    if item[1]=='enter':
        print(item[0])
    
    
