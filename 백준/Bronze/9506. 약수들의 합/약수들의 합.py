while(1):
    i=1
    n=int(input())
    sum=0
    list=[]
    
    if(n==-1): break

    while(n>i):
        if(n%i==0):
            list.append(i)
            i+=1
        else:
            i+=1

    for i in range(len(list)):
        sum+=list[i]

    if(n==sum):
        print(n,"="," + ".join(str(i) for i in list))
       # print(n,"="," + ".join(map(str,list)))
    else:
        print(n,"is NOT perfect.")

        
