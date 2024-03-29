import math
import sys
input=sys.stdin.readline

def solution(data, ext, val_ext, sort_by):
    sorted_list=[[]]
    if ext== "code" :
        code_list=[item for item in data if item[0]<val_ext]
        if sort_by == 'code':
            sorted_list=sorted(code_list, key=lambda x:x[0])
        elif sort_by == 'date':
            sorted_list=sorted(code_list, key=lambda x:x[1])
        elif sort_by == 'maximum':
            sorted_list=sorted(code_list, key=lambda x:x[2])
        else:
            sorted_list=sorted(code_list, key=lambda x:x[3])
        
    elif ext=="date":
        date_list=[item for item in data if item[1]<val_ext]
        if sort_by == "code":
            sorted_list=sorted(date_list, key=lambda x:x[0])
        elif sort_by == "date":
            sorted_list=sorted(date_list, key=lambda x:x[1])
        elif sort_by == "maximum":
            sorted_list=sorted(date_list, key=lambda x:x[2])
        else:
            sorted_list=sorted(date_list, key=lambda x:x[3])
            
    elif ext=="maximum":
        maximum_list=[item for item in data if item[2]<val_ext]
        if sort_by == "code":
            sorted_list=sorted(maximum_list, key=lambda x:x[0])
        elif sort_by == "date":
            sorted_list=sorted(maximum_list, key=lambda x:x[1])
        elif sort_by == "maximum":
            sorted_list=sorted(maximum_list, key=lambda x:x[2])
        else:
            sorted_list=sorted(maximum_list, key=lambda x:x[3])
            
    else:
        remain_list=[item for item in data if item[3]<val_ext]
        if sort_by == "code":
            sorted_list=sorted(remain_list, key=lambda x:x[0])
        elif sort_by == "date":
            sorted_list=sorted(remain_list, key=lambda x:x[1])
        elif sort_by == "maximum":
            sorted_list=sorted(remain_list, key=lambda x:x[2])
        else:
            sorted_list=sorted(remain_list, key=lambda x:x[3])
    



    return sorted_list