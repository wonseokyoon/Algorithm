N=int(input())


string_list=[]

for i in range(N):
    string_list.append(input())

unique_list=list(set(string_list))

unique_list.sort(key=lambda x:(len(x),x))


for i in unique_list:
    print(i)
    
