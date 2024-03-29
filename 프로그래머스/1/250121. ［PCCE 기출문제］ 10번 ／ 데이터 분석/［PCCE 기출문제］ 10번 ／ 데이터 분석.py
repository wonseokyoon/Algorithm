import math
import sys
input=sys.stdin.readline

def solution(data, ext, val_ext, sort_by):
    new_list=[]
    standard=["code","date","maximum","remain"]

    for item in data:
        if item[standard.index(ext)] < val_ext:
            new_list.append(item)

    sorted_list=sorted(new_list, key=lambda x:x[standard.index(sort_by)])

    
    return sorted_list