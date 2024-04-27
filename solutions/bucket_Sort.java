class BucketSort {
    public int[] bucketSort(int[] arr) {
        int[] count = {0, 0, 0};

        for (int i : arr) {
            count[i] += 1;
        }

        int i = 0;
        for (int j = 0; j < count.length; j++) {
            for (int k = 0; k < count[j]; k++) {
                arr[i] = j;
                i++;
            }
        }
        return arr;
    }

    public void sortColors(int[] nums) {
        bucketSort(nums);
    }
}