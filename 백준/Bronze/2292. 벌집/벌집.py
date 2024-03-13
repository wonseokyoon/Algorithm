N=int(input())

room=[] #1,7,19,37, ...
i=0 #외벽
num=1
while 1:
    num=num+(6*i)
    room.append(num)
    if(N<=num): break
    else:
        i+=1

print(i+1)

        
