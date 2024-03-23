// Kadanes Algorithm

class Max_SubArray {
    public int maxSubArray(int[] nums) {
        int max_sum = nums[0];
        int curr_sum = 0;

        for (int i : nums){
            curr_sum = Math.max(curr_sum,0);
            curr_sum += i;
            max_sum = Math.max(max_sum,curr_sum);
        }
        return max_sum;
    }
}