class Trap {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int water = 0;
        int max_left = 0;
        int max_right = 0;

        while (left < right) {
            max_left = Math.max(max_left,height[left]);
            max_right = Math.max(max_right,height[right]);

            if (max_left - height[left] > 0) 
                water += max_left - height[left];
            if (max_right - height[right] > 0)
                water += max_right - height[right];
            
            if (max_left > max_right) 
                right--;
            else
                left++;
        }
        return water;
    }
}