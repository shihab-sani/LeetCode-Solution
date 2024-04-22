class ClimbStairs {
    public int climbStairs(int n) {
        int left = 1;
        int right = 1;
        int temp;

        for (int i = 0; i < n-1; i++) {
            temp = left;
            left += right;
            right = temp;
        }
        return left;
    }
}