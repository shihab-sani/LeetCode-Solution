class Solution:
    def isValid(self, s: str) -> bool:
        if s[0] == ")" or s[0] == "}" or s[0] == "]":
            return False
        res = []
        for i in s:
            if i == "(" or i == "{" or i == "[":
                res.append(i)
            elif len(res) == 0:
                return False
            elif i == ")" and res[len(res)-1] != "(":
                return False
            elif i == "}" and res[len(res)-1] != "{":
                return False
            elif i == "]" and res[len(res)-1] != "[":
                return False
            else:
                res.pop()
        
        if len(res) != 0:
            return False
        else:
            return True