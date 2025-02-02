#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<int> getConcatenation(vector<int>& nums) {
        vector<int> ans(nums.size()*2);
        for (int i = 0; i < nums.size(); i++) {
            ans[i] = nums[i];
        }
        int index = 0;
        for (int j = nums.size(); j < ans.size(); j++) {
            ans[j] = nums[index];
            index++;
        }
        return ans;
    }
};