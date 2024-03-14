N,K = map(int,input().split())

#6 3
n=1
count=0
while(1):
    if(count==K or N<n): break
    
    if(N%n==0):
        count+=1
        n+=1
    else:
        n+=1

if(count<K): n=1
    
print(n-1)
