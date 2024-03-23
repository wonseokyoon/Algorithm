N=int(input())

dot_list=[]
for i in range(N):
    dot_list.append(list(map(int,input().split())))

dot_list.sort(key=lambda x:(x[1],x[0]))

for dot in dot_list:
    print(dot[0],dot[1])
