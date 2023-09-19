/*
 * @lc app=leetcode.cn id=40 lang=java
 *
 * [40] 组合总和 II
 */

// @lc code=start
class Solution {
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        backtrace(new LinkedList<Integer>(), candidates, 0, 0, target);

        return res;
    }

    private void backtrace(List<Integer> path, int[] nums, int ind, int sum, int target) {

        if (sum == target) {
            res.add(new LinkedList<Integer>(path));
            return;
        }

        if (sum > target) {
            return;
        }
        
        for (int i = ind; i < nums.length; i++) {
            // 重复的数字只计算第一个，后续的都跳过
            if (i > ind && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            sum += nums[i];
            backtrace(path, nums, i + 1, sum, target);
            path.remove(path.size() - 1);
            sum -= nums[i];
        }
    }
}
// @lc code=end

