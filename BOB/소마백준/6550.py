import sys
input = sys.stdin.readline

while True:
    try:
        s, t = input().split(' ')
        text_yes = 0
        idx = 0
        
        for i in range(len(t)):
            if t[i] == s[idx]:
                idx += 1
                if idx == len(s):
                    text_yes = 1
                    break
                
        if text_yes == 1:
            print("Yes")
        else:
            print("No")
            
    except:
        break