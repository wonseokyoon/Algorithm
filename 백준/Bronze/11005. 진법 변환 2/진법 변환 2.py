num_list="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

n,b=input().split()
remain=''

n=int(n)
b=int(b)
while n:
    remain+=str(num_list[n%b])
    n//=b

print(remain[::-1])
    
