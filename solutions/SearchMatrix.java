class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        int mid;

        while (left <= right) {
            mid = (left + right) / 2;
            if (target > matrix[mid][matrix[mid].length - 1]) {
                left = mid + 1;
            } else if (target < matrix[mid][0]) {
                right = mid -1;
            } else {
                break;
            }
        }

        if (!(left <= right)) {
            return false;
        }

        mid = (left + right) / 2;
        int top = 0;
        int bot = matrix[mid].length - 1;
        int midd;

        while (top <= bot) {
            midd = (top + bot) / 2;
            if (target > matrix[mid][midd]) {
                top = midd + 1;
            } else if (target < matrix[mid][midd]) {
                bot = midd - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}