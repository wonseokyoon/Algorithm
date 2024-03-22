num=[]
for i in range(5):
    num.append(int(input()))

num.sort()
#sorted_list=sorted(num)

sum=0
for i in range(5):
    sum+=num[i]

average=sum/5

print(int(average))
print(num[2])
#print(sorted_list[2])
