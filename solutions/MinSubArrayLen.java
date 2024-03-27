class MinSubArrayLen {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int total = 0;
        int length = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {
            total += nums[right];

            while (target <= total) {
                length = Math.min(right-left+1,length);
                total -= nums[left];
                left += 1;
            }
        }
        if (length == Integer.MAX_VALUE) {
            return 0;
        }
        return length;
    }
}