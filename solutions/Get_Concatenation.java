class Get_Concatenation {
    public int[] getConcatenation(int[] nums) {
        int size = nums.length*2;
        int[] arr = new int[size];
        System.arraycopy(nums,0,arr,0,nums.length);
        int j = nums.length;
        for (int i = 0; i<nums.length; i++){
            arr[j] = nums[i];
            j++;
        }
        return arr;
    }
}