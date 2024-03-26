
def solution(bandage, health, attacks):
    maxhealth=health        #최대 체력
    time=0                  #현재 시간
    maxtime=attacks[-1][0]   #마지막 공격 시간
    success=0               #연속성공

    attackDic={}
    for i in attacks:
        attackDic[i[0]]=i[1]    # {1:15, 5:16, 8:6}

    while time<=maxtime:
        if time in attackDic:   #몬스터 공격 타이밍
            health-=attackDic[time]
            success=0

            if health<=0:
                return -1
        else:
            success+=1
            if success==bandage[0]:  # 추가회복
                health+=bandage[1]+bandage[2]
                success=0

                if(health>maxhealth):
                    health=maxhealth
                
            else:
                health+=bandage[1]
                if(health>maxhealth):
                    health=maxhealth

        time+=1

            
    return health


