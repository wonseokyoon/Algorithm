N=int(input())

dot_list=[]    #[[3,4][1,1][1,-1][2,2][3,3]]

for i in range(N):
    dot_list.append(list(map(int,input().split())))

dot_list.sort(key=lambda x:(x[0],x[1]))    

for dot in dot_list:
    print(dot[0],dot[1])
