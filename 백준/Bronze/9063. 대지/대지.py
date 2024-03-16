x_list=[]
y_list=[]

N=int(input())

for i in range(N):
    x,y=map(int,input().split())
    x_list.append(x)
    y_list.append(y)

min_x=min(x_list)
max_x=max(x_list)
min_y=min(y_list)
max_y=max(y_list)

width=max_x - min_x
height=max_y - min_y

print(width * height)
