class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_len = 0
        idx = 0

        string = set()

        for i, j in enumerate(s):

            while j in string:
                string.remove(s[idx])
                idx += 1

            string.add(j)
            max_len = max(len(string), max_len)
            
        return max_len