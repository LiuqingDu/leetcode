/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // 维护一个固定的窗口看里面有没有重复的数据
        // 如果k等于0，又因为i与j不同，那么此时无法满足
        if (k == 0) {
            return false;
        }

        int n = nums.length;
        Set<Integer> set = new HashSet<>();

        // 遍历每一个元素
        for (int i = 0; i < n; i++) {
            // 如果set已经满了，那么先把多余的元素剔除掉
            // i - k是当前窗口的起点，多余的是这个窗口左边的那个元素，所以是i-k-1
            if (set.size() == k + 1) {
                set.remove(nums[i - k - 1]);
            }
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }
}
// @lc code=end

