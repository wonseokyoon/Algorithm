N=int(input())

num=[]

for _ in range(N):
    num.append(int(input()))

sorted_list=sorted(num)

for i in range(N):
    print(sorted_list[i])
