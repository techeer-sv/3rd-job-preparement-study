def solution(n, k):
    radix_k = convert(n, k)
    p_list = str(radix_k).split('0')

    return len([i for i in p_list if i not in ['', '1'] and check_prime(int(i))])

def convert(num, base):
    power = 0
    tmp = ''
    while num:
        tmp = str(num % base) + tmp
        num //= base
    return tmp

def check_prime(n): # 소수 검사
    for i in range(2, round(n**(1/2)) + 1):
        if n % i == 0:
            return False

    return True