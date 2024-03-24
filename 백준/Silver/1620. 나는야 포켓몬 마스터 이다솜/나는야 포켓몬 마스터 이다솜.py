import sys
input=sys.stdin.readline

N,M=map(int,input().split())

dic_num={}  #번호:이름
dic_name={} #이름:번호
for i in range(1,N+1):
    name=input().strip()
    dic_num[i]=name
    dic_name[name]=i

for i in range(1,M+1):
    string=input().strip()
    if string in dic_name:       #이름이 입력됨 key값이 이름인 dic_name이랑 비교
        print(dic_name[string])
    elif int(string) in dic_num:    #번호가 입력됨 key값이 번호인 dic_num이랑 비교
        print(dic_num[int(string)])  
    

            
