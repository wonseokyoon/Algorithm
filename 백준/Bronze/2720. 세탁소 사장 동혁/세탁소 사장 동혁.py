chages=[25,10,5,1]
T=int(input())

for _ in range(T):
    ans=[]
    C=int(input())

    for i in chages:
        res=C//i
        C%=i
        ans.append(res)

    print(*ans)
