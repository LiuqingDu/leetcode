/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {

    // 回溯方法，选中一个数字之后，剩下的数字可以从包含当前数字及后面的数字当中选择
    // 当选出来的数字之和已经超过target的时候则直接返回不再继续往下找，因为元素是正数，再往后和肯定越来越大
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    List<Integer> track = new LinkedList<Integer>();
    int sum = 0;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, target, 0);
        return res;
    }

    // 方法表示从candidates[start]开始选择一个数，选完之后和为sum
    private void backtrack(int[] candidates, int start, int target, int sum) {
        if (sum == target) {
            res.add(new LinkedList<Integer>(track));
            return;
        }

        // 如果和已经超出
        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            sum+=candidates[i];
            track.add(candidates[i]);
            backtrack(candidates, i, target, sum);
            sum-=candidates[i];
            track.remove(track.size() - 1);
        }
    }
}
// @lc code=end

