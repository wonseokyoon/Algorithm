import sys
input=sys.stdin.readline

S=input().strip()   #a b a b c

sub_S=set()

for i in range(len(S)):
    for j in range(i,len(S)):
        sub_S.add(S[i:j+1])
        
print(len(sub_S))
        

        
