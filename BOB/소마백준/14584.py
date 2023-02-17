def word_change(text, n, words):    
    for i in range(26):
        temp = ''
        
        for j in text:
            temp += chr(((ord(j)-97+i)%26)+97)
            
        for j in range(n):
            if words[j] in temp:
                return(temp)
            
text = input()

n = int(input())

words = []
for i in range(n):
    words.append(input())
    
print(word_change(text, n, words))