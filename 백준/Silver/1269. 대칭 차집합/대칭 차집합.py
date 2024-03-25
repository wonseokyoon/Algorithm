import sys
input=sys.stdin.readline

A,B=map(int,input().split())

a_set=set(map(int,input().split()))
b_set=set(map(int,input().split()))


diff_ab=a_set - b_set
diff_ba=b_set - a_set

print(len(diff_ab)+len(diff_ba))

