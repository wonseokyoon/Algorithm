import sys
input=sys.stdin.readline
#import queue
from collections import deque


def mean(nums):   #평균
    sum=0
    for num in nums:
        sum+=num
    return round(sum/len(nums))

def medium(nums): #중앙값
    return nums[len(nums)//2]

def mode(nums):   #최빈값
    cnt={}
    num_list=[]
    unique_nums=list(set(nums))
    for i in unique_nums:
        cnt[i]=0
    for i in nums:
        cnt[i]+=1
    maxx=max(cnt.values())
    for key,values in cnt.items():
        if values==maxx:
            num_list.append(key)
    num_list.sort()
    if(len(num_list)==1):
        return num_list[0]
    else:
        return num_list[1]
        
def ranges(nums):  #범위
    return nums[-1]-nums[0]


T=int(input())

nums=[]

for i in range(T):
    nums.append(int(input()))
nums.sort()

mean=mean(nums)
medium=medium(nums)
mode=mode(nums)
ranges=ranges(nums)

print(mean)
print(medium)
print(mode)
print(ranges)

