def solution(survey, choices):
    mbti = [0, 0, 0, 0]
    RT = 'RT', 'TR'
    CF = 'CF', 'FC'
    JM = 'JM', 'MJ'
    AN = 'AN', 'NA'

    for i in range(len(survey)):
        if survey[i] in RT:
            if survey[i][0] == 'T':
                mbti[0] += choices[i] - 4
            else:
                mbti[0] -= choices[i] - 4
        elif survey[i] in CF:
            if survey[i][0] == 'F':
                mbti[1] += choices[i] - 4
            else:
                mbti[1] -= choices[i] - 4
        elif survey[i] in JM:
            if survey[i][0] == 'M':
                mbti[2] += choices[i] - 4
            else:
                mbti[2] -= choices[i] - 4
        elif survey[i] in AN:
            if survey[i][0] == 'N':
                mbti[3] += choices[i] - 4
            else:
                mbti[3] -= choices[i] - 4

    answer = ''

    if mbti[0] >= 0:
        answer += 'R'
    else:
        answer += 'T'

    if mbti[1] >= 0:
        answer += 'C'
    else:
        answer += 'F'

    if mbti[2] >= 0:
        answer += 'J'
    else:
        answer += 'M'

    if mbti[3] >= 0:
        answer += 'A'
    else:
        answer += 'N'

    return answer