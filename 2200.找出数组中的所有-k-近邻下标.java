/*
 * @lc app=leetcode.cn id=2200 lang=java
 *
 * [2200] 找出数组中的所有 K 近邻下标
 */

// @lc code=start
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        // 其实就是在数组中找到等于key的元素
        // 然后找出它两边相距为k的邻居
        // 当把第一个key周围的邻居(区间)处理完后
        // 处理下一个key的区间的时候
        // 可能会跟上一个区间重复
        // 为了避免重复添加,记录一下上一个区间的右边界

        List<Integer> res = new ArrayList<>();
        int r = -1; // 上一个区间的右边界
        int n = nums.length;
        for (int j = 0; j < n; ++j) {
            // 找到key
            if (nums[j] == key) {
                // 当前区间的左边界,不能超过上一个区间的右边界
                // 上一个右边界是处理过的,所以要加1
                int l = Math.max(r + 1, j - k);
                // 右边界,不能超过数组的右边界
                r = Math.min(n - 1, j + k);
                // 这里l和r是包含的,是[l,r]
                for (int i = l; i <= r; ++i) {
                    res.add(i);
                }
            }
        }
        return res;
    }
}
// @lc code=end

