angle_list=[]

for i in range(3):
    angle_list.append(int(input()))

sum=0
for i in range(3):
    sum+=angle_list[i]

if(sum != 180):
    print("Error")

else:
   if(angle_list.count(angle_list[i])==3):
       print('Equilateral')
   elif(angle_list.count(angle_list[i])==2):
       print('Isosceles')
   else:
       print('Scalene')
