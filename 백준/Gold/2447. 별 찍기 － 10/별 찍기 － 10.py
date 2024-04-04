import sys
input=sys.stdin.readline
#import queue
from collections import deque

def star(N):
    if N==3:
       return[['*','*','*'],['*',' ','*'],['*','*','*']]
    
    else:
        sub_star=star(N//3)
        pattern=[[' ' for _ in range(N)]for _ in range(N)]
        for i in range(N):
            for j in range(N):
                if N//3 <= i < 2*(N//3) and N//3 <= j < 2*(N//3):   #공백패턴
                    pattern[i][j]=' '
                else:
                    pattern[i][j]=sub_star[i%(N//3)][j%(N//3)]
        return pattern

N=int(input())
res=star(N)
for row in res:
    print(''.join(row))
