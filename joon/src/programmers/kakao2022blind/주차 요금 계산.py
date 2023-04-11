def solution(fees, records):

    records.sort()
    in_log = {}
    answer = {}

    for i in records:
        logs = i.split(' ')
        if logs[2] == 'IN':
            in_log[logs[1]] = logs[0]
        else:
            in_h, in_m = in_log[logs[1]].split(':')
            out_h, out_m = logs[0].split(':')

            in_m = int(in_m)
            out_m = int(out_m)

            in_m += int(in_h) * 60
            out_m += int(out_h) * 60

            if logs[1] in answer:
                answer[logs[1]] += out_m - in_m
            else:
                answer[logs[1]] = out_m - in_m

            del in_log[logs[1]]

    for k, v in in_log.items():
        in_h, in_m = v.split(':')
        out_h, out_m = 23, 59

        in_m = int(in_m)

        in_m += int(in_h) * 60
        out_m += out_h * 60

        if k in answer:
            answer[k] += out_m - in_m
        else:
            answer[k] = out_m - in_m

    answer = dict(sorted(answer.items()))

    a = []
    for k, v in answer.items():
        if v <= fees[0]:
            a.append(fees[1])
        else:
            if (v - fees[0]) % fees[2] == 0:
                a.append((v - fees[0]) // fees[2] * fees[3] + fees[1])
            else:
                a.append(((v - fees[0]) // fees[2] + 1) * fees[3] + fees[1])


    return a