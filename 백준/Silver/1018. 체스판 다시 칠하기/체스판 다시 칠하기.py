N,M=map(int,input().split())

chess=[]
num=[]  #num 리스트

for _ in range(N):
    row=input()
    chess.append(row)


for i in range(N-7):
    for j in range(M-7):
        W_cnt=0    #흰색 start일때 색칠해야 하는 경우의 수
        B_cnt=0    #검정색 start일때 색칠해야 하는 경우의 수
        for n in range(i,i+8):
            for m in range(j,j+8):
                if((n+m)%2 == 0):     #n+m이 짝수일 경우
                    #해당 위치를 흰색칠해야한다 -> 시작위치 흰색
                    if(chess[n][m]!='W'):
                        W_cnt+=1
                    else:
                        #해당 위치를 검정칠해야한다 -> 시작위치 검정색
                        B_cnt+=1

                else:    #n+m이 홀수일 경우
                    #해당 위치를 검정칠해야 한다-> 시작 위치가 흰색이다
                    if(chess[n][m]!='B'):    
                        W_cnt+=1
                    #해당 위치 검를 흰색칠 해야한다-> 시작 위치가 검정색이다
                    else:
                        B_cnt+=1

        num.append(min(W_cnt,B_cnt))    # 두 수중 작은 값 입력
print(min(num)) #최소값 출
