
N=int(input())

res=[] # [4,9,25,81, ... ]

for i in range(N+1):
    dot=(1+2**i)**2
    res.append(dot)

num=res[N]#-res[N-1]
print(int(num))
