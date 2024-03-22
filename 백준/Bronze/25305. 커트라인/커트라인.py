N,K=map(int,input().split())

num=[]
input_string=input()
num=list(map(int,input_string.split()))

num.sort(reverse=True)



print(num[K-1])
