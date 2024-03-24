import sys
input=sys.stdin.readline

N=int(input())
card=[]
card=list(map(int,input().split()))   #6 3 2 10 10 10 -10 -10 7 3
card.sort()         #-10 -10 2 3 3 6 7 10 10 10

cnt=0
M=int(input())
card2=list(map(int,input().split()))

dict={}

for i in card2:
    dict[i]=0              #10:0, 9:0, -5:0 ...

for i in card:
    if i in dict:
        dict[i]+=1
    

for i in card2:
    if i in dict:
        print(dict[i],end=" ")
    else:
        print(0,end=" ")

