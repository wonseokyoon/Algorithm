N,M=map(int,input().split())

nums=list(map(int,input().split())) #5 6 7 8 9
#nums.sort()     #오름차순 정렬
#print(nums)

sum=0
max_sum=0
for i in range(N-2):
    for j in range(i+1,N-1):
        for k in range(j+1,N):
            sum=nums[i]+nums[j]+nums[k]
            if(sum<=M and max_sum<sum):
                max_sum=sum
            
        

print(max_sum)
        
    
