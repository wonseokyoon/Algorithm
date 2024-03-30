import sys
input=sys.stdin.readline

N=int(input())

students=[]
students=list(map(int,input().split())) #5 4 1 3 2 , 4 5 3 2 1

stack=[]
sequence=1
for student in students:
    stack.append(student)

    
    while stack and sequence==stack[-1]:
        sequence+=1
        stack.pop()


if stack:
    print("Sad")
else:
    print("Nice")
            
        

        
