import math
import sys
input=sys.stdin.readline

def gcd(x,y):       #최대 공약수 
    return math.gcd(x,y)


a,b=map(int,input().split())
c,d=map(int,input().split())

gcd_bd=gcd(b,d) #분모들의 최대 공약수


deno=(b*d)//gcd_bd    #분모: 최소공배수

multi_a=deno//b    # A에 곱해야하는 수
multi_c=deno//d    # C에 곱해야하는 수

molecul=multi_a*a+multi_c*c   #분자

print(molecul//gcd(molecul,deno),deno//gcd(molecul,deno))
