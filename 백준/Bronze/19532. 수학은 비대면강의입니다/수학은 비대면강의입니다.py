a,b,c,d,e,f = map(int,input().split())
x=(e*c-b*f)/(a*e-b*d)

if(b==0):
    y=(f-d*x)/e
else:   #e==0
    y=(c-a*x)/b

print(int(x),int(y))
