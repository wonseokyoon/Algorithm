a,b,v=map(int,input().split())

day=(v-b)//(a-b)
remain=(v-b)%(a-b)

if(remain==0):
    print(day)
else:
    print(day+1)



