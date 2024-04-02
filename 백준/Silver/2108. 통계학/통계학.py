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
    dic={}
    mode_list=[]
    for num in nums:
        if num not in dic:
            dic[num]=1
        else:
            dic[num]+=1
    maxx=max(dic.values())
    for key,value in dic.items():
        if maxx==value:
            mode_list.append(key)
    if len(mode_list)==1:
        return mode_list[0]
    else:
        return mode_list[1]
        
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

