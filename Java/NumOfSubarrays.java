// Sliding windows mathod

class NumOfSubarrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int result = 0;
        int count = 0;
        int total = 0;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {
            total += arr[right];
            count ++;
            if (count > k) {
                count = k;
                total -= arr[left];
                left++;
            }
            if (count == k) {
                int avg = total/k;
                if (avg >= threshold) {
                    result++;
                }
            }
        }
        return result;
    }
}