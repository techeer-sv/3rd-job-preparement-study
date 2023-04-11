def solution(today, terms, privacies):
    t = {}
    d = today.split('.')
    d = [int(i) for i in d]
    answer = []

    for i in range(len(terms)):
        t[terms[i][0]] = terms[i][2:]

    for i in range(len(privacies)):
        date = privacies[i][:-2].split('.')

        if bigyo(d, date, t[privacies[i][-1]]):
            answer.append(i + 1)

    return answer

def bigyo(d, date, m):
    date = [int(i) for i in date]

    date[1] += int(m)
    while date[1] > 12:
        date[1] -= 12
        date[0] += 1

    if date[0] < d[0]:
        return True
    elif date[0] == d[0] and date[1] < d[1]:
        return True
    elif date[0] == d[0] and date[1] == d[1] and date[2] <= d[2]:
        return True
    return False