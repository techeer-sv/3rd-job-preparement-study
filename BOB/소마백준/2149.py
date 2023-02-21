key = list(input())
text = list(input())

text_list = []
key_sort = key
key_sort.sort()

for i in key_sort:
    text_list.append([i])
    
last_index = 0
 
for i in range(len(text)//len(key)):
    for j in range(len(text_list)):
        text_list[j].append(text[last_index])
        last_index += 1

print(text_list)

# ['D', 'G', 'H', 'I', 'M', 'N', 'U']


save_list = []

for i in range(len(key)):
    for j in range(len(key)):
        if key[i] == text_list[j][0]:
            save_list.append(text_list[j])
            
print(save_list)

last_text = ''   
     
for i in range(len(key)):
    for j in range(1, len(save_list[i])):
        last_text += save_list[i][j]

print(last_text)
# for i in range(len(key)):
#     for j in range(len(text_list[i])):
#         print(text_list[i][j])