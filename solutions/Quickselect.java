class Quickselect {

    public static int quickselect(int[] arr, int left, int right, int k) {
        int pivot = arr[right];
        int start = left;

        for (int i = left; i < right; i++) {
            if (arr[i] < pivot) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                start++;
            }
        }
        arr[right] = arr[start];
        arr[start] = pivot;

        if (k < start) {
            return quickselect(arr, left, start - 1, k);
        } else if (k > start) {
            return quickselect(arr, start + 1, right, k);
        } else {
            return arr[start];
        }

    }
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        return quickselect(nums, 0, nums.length - 1, k);
    }
}