import sys
input=sys.stdin.readline
#import queue
from collections import deque

def cut(string,start,end):
    div=(end-start+1)//3
    if div==0:
        return '-'


    for i in range(start+div,start+div*2):
        string[i]=' '
        
    cut(string,start,start+div-1)
    cut(string,start+div*2,end)
    
while True:
    try:
        n=int(input())
        string=['-']*(3**n)
        cut(string,0,(3**n)-1)
        print(''.join(string))
    except:
        break
        
