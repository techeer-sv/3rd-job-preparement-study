import math

def min(time):
    hour, minute = time.split(":")
    return int(hour) * 60 + int(minute)
    
def solution(fees, records):
    car_number = []
    cut = 0

    for i in range(len(records)):
        time, num, io = records[i].split()
        if num in car_number:
            continue
        else:
            car_number.append(num)
    car_number.sort()
    answer = [0 for _ in range(len(car_number))]

    for i in range(len(records)):
        time, num, io = records[i].split()
        if io == 'IN':
            cut += -min(time)
            for j in range(i, len(records)):
                time_o, num_o, io_o = records[j].split()
                if num == num_o and io_o == "OUT":
                    cut += min(time_o)
                    answer[car_number.index(num)] += cut
                    cut = 0
                    break
                elif j < len(records) - 1:
                    continue
                else: 
                    cut += min('23:59')
                    answer[car_number.index(num)] += cut
                    cut = 0
                    break
                    
    for i in range(len(answer)):
        if fees[0] > answer[i]:
            answer[i] = fees[1]
        else:
            answer[i] = fees[1] + math.ceil((int(answer[i]) - fees[0])/fees[2]) * fees[3]
        
    return answer