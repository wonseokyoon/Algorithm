import sys
input=sys.stdin.readline
#import queue
from collections import deque

    
def dfs(cnt,idx):
    global min_res
    if cnt==N//2:
        start,link=0,0
        for i in range(N):
            for j in range(N):
                if not visited[i] and not visited[j]:
                    start+=board[i][j]
                elif visited[i] and visited[j]:
                    link+=board[i][j]
        min_res=min(min_res,abs(start-link))

    for i in range(idx,N):
        if not visited[i]:
            visited[i]=1
            dfs(cnt+1,i+1)
            visited[i]=False

            
                
N=int(input())
board=[]
row=[]
for i in range(N):
    row=list(map(int,input().split()))
    board.append(row)

min_res=float('inf')
visited=[0]*N
dfs(0,0)
print(min_res)


