import sys
input = sys.stdin.readline

N_string=input().strip()


N=[int(digit) for digit in N_string]

N.sort(reverse=True)
N=''.join(map(str,N))
print(N)
