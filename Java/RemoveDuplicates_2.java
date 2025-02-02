class RemoveDuplicates_2 {
    public int removeDuplicates(int[] nums) {
        int k = 0;
        int count = 1;
        
        for (int i = 1; i < nums.length; i++) {
            if (nums[k] == nums[i]) {
                if (count < 2) {
                    count++;
                    nums[++k] = nums[i];
                }
            } else {
                count = 1;
                k++;
                nums[k] = nums[i];
            }
        }
        return ++k;
    }
}