

while(1):
    x,y = map(int,input().split())
    if(x==0 and y==0): break
    else:
        #첫 번째 숫자가 두 번째 숫자의 약수이다.	=>factor
        if(y%x==0):
            print("factor")

        #2.첫 번째 숫자가 두 번째 숫자의 배수이다.	=>multiple
        elif(x%y==0):
            print("multiple")

        else:
            print("neither")
