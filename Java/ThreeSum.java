import java.util.ArrayList;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> sets = new HashSet<>();
        ArrayList<List<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;

            while (left < right) {
                if ((nums[left] + nums[right] + nums[i]) > 0) {
                    right--;
                }
                else if ((nums[left] + nums[right] + nums[i]) < 0) {
                    left++;
                }
                else {
                    sets.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                }
            }
        } 
        arr.addAll(sets);
        return arr;
    }
}