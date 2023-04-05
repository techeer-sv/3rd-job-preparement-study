def solution(id_list, report, k):

    report_set = set(report)
    id_dict = {i: [] for i in id_list}
    report_dict = {i: 0 for i in id_list}

    for i in report_set:
        temp = i.split(' ')
        id_dict[temp[0]].append(temp[1])
        report_dict[temp[1]] += 1

    alert = [id for (id, v) in report_dict.items() if v >= k]

    answer = []
    for (i, l) in id_dict.items():
        answer.append(len([c for c in l if c in alert]))
    return answer