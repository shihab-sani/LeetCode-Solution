// using Kadanes Algorithm logic

class MaxSubarraySumCircular {
    public int maxSubarraySumCircular(int[] nums) {
        int max_sum = nums[0];
        int min_sum = nums[0];
        int curr_max = 0;
        int curr_min = 0;
        int total = 0;

        for (int i : nums){
            curr_max = Math.max(curr_max+i,i);
            curr_min = Math.min(curr_min+i,i);
            total += i;
            max_sum = Math.max(max_sum,curr_max);
            min_sum = Math.min(min_sum,curr_min);
        }
        total -= min_sum;
        if (max_sum > 0)
            return Math.max(max_sum,total);
        return max_sum;
    }
}