class MaxArea {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int length = 0;
        int result = 0;

        while (left < right) {

            length =  (Math.min(height[left],height[right]) * (right-left));
            result = Math.max(result,length);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return result;
    }
}