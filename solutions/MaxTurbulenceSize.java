class MaxTurbulenceSize {
    public int maxTurbulenceSize(int[] arr) {
        int right = 1;
        int left = 0;
        int result = 1;
        String sign = "";

        while (right < arr.length) {
            if (arr[right - 1] < arr[right] && sign != "<") {
                result = Math.max(result, right - left + 1);
                right += 1;
                sign = "<";
            }
            else if (arr[right - 1] > arr[right] && sign != ">") {
                result = Math.max(result, right - left + 1);
                right += 1;
                sign = ">";
            }
            else {
                if (arr[right] == arr[right-1]) {
                    right += 1;
                }
                left = right-1;
                sign = "";
            }
        }
        return result;
    }
}