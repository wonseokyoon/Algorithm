N=int(input())
num_list=list(map(int,input().split()))

#[1,3,5,7]
count=0

for index,num in enumerate(num_list):
    i=2
    
    if(num==1):
        continue

    else:
        while(num>=i):
            if(num%i==0):
                if(num==i):
                    count+=1
                    break
                else: break
            else:
                i+=1


print(count)


