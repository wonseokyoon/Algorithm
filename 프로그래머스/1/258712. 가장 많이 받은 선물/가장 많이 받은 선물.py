import math
import sys
input=sys.stdin.readline


def solution(friends, gifts):
    #friends=[]
    #gifts=[]
    gifted={}   # 이름:{선물받은 친구 이름:준 선물 갯수, ... , ...}
    gift_num={} # 이름 : 선물지수

    for friend in friends:
        gifted[friend]={}
        gift_num[friend]=0

    for gift in gifts:
        give,recieve=gift.split(' ')
        if recieve in gifted[give]: #선물을 준 기록이 있다면
            gifted[give][recieve]+=1
        else:
            gifted[give][recieve]=1

        gift_num[give]+=1
        gift_num[recieve]-=1

    will_get=[0]* len(friends)
    
    for i in range(len(friends)):
        me=friends[i]
        for j in range(i+1,len(friends)):
            other=friends[j]
            #내가 다른 친구에게 준 선물의 갯수
            give_num=gifted[me][other] if other in gifted[me] else 0
            recieve_num=gifted[other][me] if me in gifted[other] else 0
            if other in gifted[me]:
                give_num=gifted[me][other]
            else:
                give_num=0
            #다른 친구가 내게 준 선물의 갯수
            if me in gifted[other]:
                recieve_num=gifted[other][me]
            else:
                recieve_num=0

            if give_num>recieve_num:    # 내가 준 선물 갯수가 더 많음
                will_get[i]+=1
            elif give_num<recieve_num:  # 내가 받은 선물 갯수가 더 많음
                will_get[j]+=1
            elif give_num==recieve_num: # 주고 받은 선물 갯수가 같음
                if gift_num[me]>gift_num[other]:      #선물지수가 내가 더 높음
                    will_get[i]+=1
                elif gift_num[me]<gift_num[other]:    #선물지수가 내가 더 낮음
                    will_get[j]+=1

    answer=max(will_get)

    return answer