import sys
input=sys.stdin.readline
N=int(input())

num_list=[]
num_list=list(map(int,input().split()))     #2 4 -10 4 -9
sorted_list=sorted(list(set(num_list)))        #-10 -9 2 4

dic={}
for i in range(len(sorted_list)):                     #-10:0, -9:1, 2:2, 4:3
    dic[sorted_list[i]]=i

for i in num_list:
    print(dic[i],end=" ")
    
