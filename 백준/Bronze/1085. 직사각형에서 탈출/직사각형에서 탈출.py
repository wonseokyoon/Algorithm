x,y,w,h=map(int,input().split())

def find_min_distance(x,y,w,h):
    min_distance=min(x,y,w-x,h-y)
    return min_distance

min_distance=find_min_distance(x,y,w,h)
print(min_distance)
