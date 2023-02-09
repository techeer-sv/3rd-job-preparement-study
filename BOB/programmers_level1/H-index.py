def solution(citations):
    h = 0
    
    for i in range(10001):
        h_up = 0
        h_down = 0
        
        for j in range(len(citations)):
            if citations[j] >= i:
                h_up += 1
            if citations[j] <= i:
                h_down += 1

        if h_up >= i and h_down <= i:
            if i > h:
                h = i
    
    return h