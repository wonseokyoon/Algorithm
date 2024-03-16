while(1):
    x,y,z=map(int,input().split())

    if(x==0 or y==0 or z==0):
        break

    else:
        max_len=max(x,y,z)
        sum=x+y+z
    
        if(max_len>=sum-max_len):
            print('Invalid')
            continue
    
        if(x==y):
            if(x==z):
                print('Equilateral')
            else:
                print('Isosceles')

        elif(x==z):
            print('Isosceles')

        elif(y==z):
            print('Isosceles')

        else:
            print('Scalene')
    
