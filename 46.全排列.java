/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start

class Solution {
    // 记录最终结果
    List<List<Integer>> res = new LinkedList<List<Integer>>();
    // 记录当前选择的排列
    List<Integer> cur = new LinkedList<Integer>();
    // 记录已经选择过的值
    Set<Integer> set = new HashSet<Integer>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return res;
    }

    // 回溯做选择
    // 当选择的长度等于数组长度的时候说明已经选择完，加到结果中
    private void backtrack(int[] nums) {
        if (cur.size() == nums.length) {
            // cur 是复用的，所以需要复制一份出来加到结果里
            res.add(new LinkedList(cur));
            return;
        }

        // 依次做选择
        for (int i = 0; i < nums.length; i ++) {
            // 只能选择还没有选择过的数字
            if (!set.contains(nums[i])) {
                // 记录已经选择的数字
                set.add(nums[i]);
                cur.add(nums[i]);
                // 进行下一步选择
                backtrack(nums);
                // 后面的都已经选择完毕，撤销当前选择，回到上一步
                set.remove(nums[i]);
                cur.remove(cur.size() - 1);
            }
        }
    }
}
// @lc code=end

