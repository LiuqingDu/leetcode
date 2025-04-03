/*
 * @lc app=leetcode.cn id=1403 lang=java
 *
 * [1403] 非递增顺序的最小子序列
 */

// @lc code=start
class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        // 实际上满足题目要求就只需要做到优先取最大的数字
        // 即可又保证数量最少且总和最大

        // 先排序然后从大到小取,直到总和大于剩下的
        int total = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<Integer>();
        int curr = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            curr += nums[i];
            ans.add(nums[i]);
            if (total - curr < curr) {
                break;
            }
        }
        return ans;
    }
}
// @lc code=end

