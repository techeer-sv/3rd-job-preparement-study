# 날짜 기준으로 변환
def day_count(date):
    y, m, d = map(int, date.split('.'))
    m += y * 12
    d += m * 28
    return d

def check_answer(end_dates, today):
    target = day_count(today)
    ans = []
    for index, value in end_dates:
        if target >= value:
            ans.append(index)
    return ans

def solution(today, terms, privacies):
    # 약관: 유효기간
    terms_dic = {}
    end_dates = []
    
    for i in terms:
        term_key, term_value = i.split(' ')
        terms_dic[term_key] = int(term_value)
    
    for i in range(len(privacies)):
        date, r = privacies[i].split()
        value = day_count(date)
        value += terms_dic[r] * 28
        end_dates.append([i + 1, value])

    return check_answer(end_dates, today)