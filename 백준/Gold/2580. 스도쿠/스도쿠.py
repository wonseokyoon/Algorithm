import sys
input=sys.stdin.readline
#import queue
from collections import deque


def is_valid(board,row,col,num):
    #행일치
    for i in range(9):
        if board[row][i]==num:
            return False
    #열일치
    for j in range(9):
        if board[j][col]==num:
            return False
    #작은 사각형 일치
    start_small_row,start_small_col=3*(row//3),3*(col//3)
    for row in range(3):
        for col in range(3):
            if board[start_small_row+row][start_small_col+col]==num:
                return False
    return True


def sudoku(board):
    if not is_empty(board):
        return True
    row,col=is_empty(board)
    
    for num in range(1,10):
        if is_valid(board,row,col,num):
            board[row][col]=num
            if sudoku(board):
                return True
            board[row][col]=0
    return False

def is_empty(board):
    for i in range(9):
        for j in range(9):
            if board[i][j]==0:
                return i,j




board=[]
for i in range(9):
    row=list(map(int,input().split()))
    board.append(row)

sudoku(board)

for row in board:
    print(' '.join(map(str,row)))
