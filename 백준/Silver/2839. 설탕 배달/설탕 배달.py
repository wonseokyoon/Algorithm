N=int(input())    #11

share_5=N//5    #2
share_3=N//3    #3
min=N

is_valid=0
for x in range(share_5+1):
    for y in range(share_3+1):
        if( (5*x) + (3*y) ==N ):
            if(min>x+y): min=x+y
            is_valid=1
            break;


if is_valid==1:    # 위 식을 통과 못했다면 -1 출력
    print(min)
else: print(-1)
