/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 非递减子序列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        // 明显回溯，注意一个问题，同一层应该跳过重复元素
        // 比如 【4,6,7,7】
        // 标记一下两个7
        // [4,6,7^,7*]
        // 当第一个7^形成了[4,6,7^] 后
        // 不要再次在第三个元素(第三层)上选择7*
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> path, int[] nums, int start) {
        if (path.size() > 1) {
            result.add(new ArrayList<>(path));
        }

        // 记录本层选过的元素
        HashSet<Integer> used = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            // 如果新数字比选过的最后一个数字还小,则跳过
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1)) {
                continue;
            }

            // 本层用过了则跳过
            if (used.contains(nums[i])) {
                continue;
            }

            // 选择
            path.add(nums[i]);
            // 记录本层用过的
            used.add(nums[i]);
            backtrack(result, path, nums, i + 1);
            // 撤销选择
            path.remove(path.size() - 1);
            // 不能撤销本层用过的,避免重复计算
        }
    }
}
// @lc code=end

