import math
import sys
input=sys.stdin.readline

def solution(board, h, w):
    answer = 0
    n=len(board)

    dh=[0,1,-1,0]    #h축 움직임
    dw=[1,0,0,-1]    #w축 움직임

    for i in range(4):
        h_check=h+dh[i]
        w_check=w+dw[i]
        if(0<=h_check<n and 0<=w_check<n):
            if(board[h][w]== board[h_check][w_check]):
                answer+=1


    return answer



