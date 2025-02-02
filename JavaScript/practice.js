/**
 * @param {number[]} nums
 * @return {number[]}
 */
var getConcatenation = function(nums) {
    let size = nums.length;
    let arr = Array(size*2).fill(0);
    for (let i = 0; i < size; i++) {
        arr[i] = nums[i];
        arr[i+size] = arr[i];
    }
    return arr;
};