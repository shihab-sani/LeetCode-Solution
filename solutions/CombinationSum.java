import java.util.List;
import java.util.ArrayList;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        sum(candidates, 0, subset, result, 0, target);

        return result;
    }

    private void sum(int[] candidates, int i, List<Integer> sub, List<List<Integer>> res, int total, int target) {
        if (total == target) {
            res.add(new ArrayList<>(sub));
            return;
        }
        if (i >= candidates.length || target < total) {
            return;
        }

        sub.add(candidates[i]);
        sum(candidates, i, sub, res, candidates[i] + total, target);
        sub.remove(sub.size() - 1);
        sum(candidates, i + 1, sub, res, total, target);
    }
}