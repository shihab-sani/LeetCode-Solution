#include <iostream> 
#include <vector>
using namespace std;

class Solution {
public:
    bool isValid(string s) {
        char* res = new char[s.length()];
        int size = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s[i];
            if (c == '(' || c == '{' || c == '[') {
                res[size] = c;
                size++;
            } else if (size == 0) {
                return false;
            } else if (c == ')' && res[size-1] != '(') {
                return false;
            } else if (c == '}' && res[size-1] != '{') {
                return false;
            } else if (c == ']' && res[size-1] != '[') {
                return false;
            } else {
                size--;
            }
        }
        if (size != 0) {
            return false;
        }
        return true;
    }
};