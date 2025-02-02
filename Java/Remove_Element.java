class Remove_Element {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        int i = 0;
        while (i<nums.length){
            if (nums[i] != val){
                nums[index] = nums[i];
                index++;
            }
            i++;
        }
        return index;
    }
}
