/*
 * @lc app=leetcode.cn id=494 lang=java
 *
 * [494] 目标和
 */

// @lc code=start
class Solution {
    // 比较容易想到的就是回溯，把每种可能性都尝试一下，
    // 这样肯定有重复计算的，用一个备忘录记录一下

    // 记录每个式子的值，式子用字符串表示
    HashMap<String, Integer> memo = new HashMap<String, Integer>();

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }

        return backtrace(nums, 0, target);

    }

    // 表示现在该选择nums[i]这个数字了，距离目标值还剩下remain需要凑出来
    // 直到remain为0，说明之前的数字已经凑出目标值了
    private int backtrace(int[] nums, int i, int remain) {
        // 当所有数字都用完了才判断是否凑出目标
        if (i == nums.length) {
            // 如果剩余要凑的数字是0，说明已经凑够了
            if (remain ==0) {
                return 1;
            } else {
                // 否则凑不出来
                return 0;
            }
        }

        // 表示取到第i个数字了，还需要凑remain，这种情况下是否已经被计算过了？
        // 这就是剪枝
        String exp = i + "," + remain;

        if (memo.containsKey(exp)) {
            return memo.get(exp);
        }

        // 当前这个节点有两个选择，要么加这个数字要么减这个数字，两种情况分别计算凑出的方案数
        // 相加就是当前节点的方案数
        int result = backtrace(nums, i + 1, remain - nums[i]) + backtrace(nums, i + 1, remain + nums[i]);

        // 记录下来避免重复计算
        memo.put(exp, result);

        // 返回结果
        return result;
    }


}
// @lc code=end

