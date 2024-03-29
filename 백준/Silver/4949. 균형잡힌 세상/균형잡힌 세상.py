import math
import sys
input=sys.stdin.readline


while True:
    scount=0
    bcount=0
    stack=[]
    string=input().rstrip()

    if string == ".":
        break

    for s in string :
        if s =='(' or s=='[':
            stack.append(s)
        elif s==')':
            if stack and stack[-1]=='(':
                stack.pop()
            else:
                print('no')
                break
        elif s==']':
            if stack and stack[-1]=='[':
                stack.pop()
            else:
                print("no")
                break
    else:       # break문으로 중단되지 않았을 경우 실행
        if stack :
            print("no")
        else:
            print("yes")
