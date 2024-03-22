import sys
input = sys.stdin.readline

N= int(input())

#입력받는 원소의 최댓값=10000 이므로 크기제한
#모든 리스트 요소 0으로 초기화(숫자 등장횟수)
num=[0]*10001

for i in range(N):
    n=int(input())
    num[n]+=1    #숫자 n의 등장횟수 +1

for i in range(10001):
    if num[i]:  #num[i]가 0이면 pass
        for _ in range(num[i]):
            print(i)
