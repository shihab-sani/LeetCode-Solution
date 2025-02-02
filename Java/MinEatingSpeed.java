import java.util.Arrays;

class MinEatingSpeed {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = Arrays.stream(piles).max().getAsInt();
        int ans = 0;
        int mid;
        int sum;

        while (start <= end) {
            mid = start + (end - start) / 2;
            sum = 0;
            for (double i : piles) {
                double c = i / mid;
                sum += Math.ceil(c);
            }
            if (sum <= h) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }
}