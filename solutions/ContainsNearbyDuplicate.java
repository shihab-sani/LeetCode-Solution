// siding windows mathod
import java.util.HashSet;

class ContainsNearbyDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int left = 0;
        HashSet<Integer> window = new HashSet<>();

        for (int right = 0; right < nums.length; right++) {
            if (window.size() > k) {
                window.remove(nums[left]);
                left++;
            }
            if (window.contains(nums[right])) 
                return true;
            window.add(nums[right]);
        }
        return false;
    }
}