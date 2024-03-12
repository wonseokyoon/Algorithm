num_list="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"

n,b=input().split()
#ZZZZZ 36 -> 35*36^4 + 35*36^3 + --- +35*36^0
#ABCDE 36 -> 14*36^4 + 13*36^3 + --- + 10*36^0

ans=0
b=int(b)
for index,num in enumerate(n):
    ans += num_list.index(num) * (b**(len(n)-index-1))

print(ans)
                            

