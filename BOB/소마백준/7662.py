import heapq

def solution(di_list, value_list):
    max_h = []
    min_h = []
    visited = [False] * 1000000
    
    for i in range(len(di_list)):
        # insert
        if di_list[i] == 'I':
            heapq.heappush(max_h, (-value_list[i], i))
            heapq.heappush(min_h, (value_list[i], i))
            visited[i] = True
        # delete
        else:
            # 최솟값 삭제
            if value_list[i] == -1:
                while max_h:
                    if visited[min_h[0][1]] == True:
                        heapq.heappop(min_h)
                    else:
                        break
                if min_h:
                    min = min_h[0][1]
                    visited[min] = True
                    heapq.heappop(min_h)
                    
            # 최댓값 삭제
            elif value_list[i] == 1:
                while max_h:
                    if visited[max_h[0][1]] == 1:
                        heapq.heappop(min_h)
                    else:
                        break
                if max_h:
                    max = max_h[0][1]
                    visited[max] = True
                    heapq.heappop(max_h)
    while min_h:
        if visited[min_h[0][1]] == 1:
            heapq.heappop(min_h)
        else:
            break
    while max_h:
        if visited[max_h[0][1]] == 1:
            heapq.heappop(max_h)
        else:
            break
    
    if min_h:
        print(-max_h[0][0], min_h[0][0])
    else:
        print("EMPTY")
        
    return


for i in range(int(input())):
    di_list = []
    value_list = []
    for j in range(int(input())):
        di, value = input().split(' ')
        di_list.append(di)
        value_list.append(int(value))

    solution(di_list, value_list)