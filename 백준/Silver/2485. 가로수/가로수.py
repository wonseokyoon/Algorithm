import math
import sys
input=sys.stdin.readline

def gcd(x,y):
    return math.gcd(x,y)

N=int(input())

tree=[]
for i in range(N):
    tree.append(int(input()))     #1 3 7 13
    
dis=[]
for i in range(len(tree)-1):    #2 4 6
    dis.append(tree[i+1]-tree[i])


res=dis[0]
for i in range(len(dis)): #2 4 6
    res=gcd(res,dis[i])

all_tree=(max(tree)-min(tree))//res+1
print(all_tree-len(tree))
