def solution(info, edges):
    # 0은 양, 1은 늑대
    answer = []
    visited = [0] * len(info)
    
    def dfs(sheep, wolf):
        if sheep > wolf:
            answer.append(sheep)
        else:
            return
        
        for i in edges:
            if visited[i[0]] and not visited[i[1]]:
                visited[i[1]] = 1
                if info[i[1]] == 0:
                    dfs(sheep + 1, wolf)
                else:
                    dfs(sheep, wolf + 1)
                visited[i[1]] = 0

    visited[0] = 1
    dfs(1, 0)
    
    return max(answer)