import sys
input=sys.stdin.readline
#import queue
from collections import deque

def is_valid(board,row,col,num):
    # 행에 중복된 숫자가 있는지 확인
    for i in range(9):
        if board[row][i]==num:
            return False
    # 열에 중복된 숫자가 있는지 확인
    for i in range(9):
        if board[i][col]==num:
            return False
    # 작은 사각형에 중복된 숫자가 있는지 확인
    small_start_row,small_start_col=3*(row//3), 3*(col//3)
    #작은 사각형 내부의 시작좌표(0,0)를 재 설정
    for row in range(3):
        for col in range(3):
            if board[small_start_row+row][small_start_col+col]==num:    
                return False
    return True

def sudoku(board):
    if not is_empty(board):     #보드를 가득 채운 상태
        return True
    row,col=is_empty(board)     # 빈칸의 행과 열 저장

    for num in range(1,10):
        if is_valid(board,row,col,num):     # 해당 숫자가 빈칸에 들어갈 수 있으면
            board[row][col]=num             # 해당 숫자 입력
            if sudoku(board):               # 슈도쿠가 완성이 됐다면(동시에 재귀호출)
                return True
            board[row][col]=0               # 빈칸에 숫자가 못들어 갈 경우(잘못된 case)에 백트래킹
    return False

def is_empty(board):
    for i in range(9):
        for j in range(9):
            if board[i][j]==0:
                return i,j
    




board=[]
for _ in range(9):
    row=list(map(int,input().split()))
    board.append(row)

sudoku(board)
for row in board:
    print(' '.join(map(str,row)))
