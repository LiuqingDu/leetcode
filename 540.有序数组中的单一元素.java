/*
 * @lc app=leetcode.cn id=540 lang=java
 *
 * [540] 有序数组中的单一元素
 */

// @lc code=start
class Solution {
    public int singleNonDuplicate(int[] nums) {
        // 题目要求复杂度 logn, 明显要用二分法
        // 观察中点有什么特点,考虑到它可能跟两边的数字相等
        // 需要根据中点的奇偶来分别考虑
        // 如果中点索引是偶数,说明它左边有偶数个元素
        // 如果左边没有单一元素,那么中点跟它左边的元素应该不同
        // 因此可以得出如果中点跟它左边不同,那么左边就没有单一元素
        // 则单一元素在中点及右边区域
        // 如果中点索引是奇数,说明它左边有奇数个元素
        // 如果左边没有单一元素,那么中点左边的元素应该跟中点相同
        // 后续逻辑相同

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (right - left) / 2 + left;
            if (mid % 2 == 0) {
                // 如果中点是偶数,那么左边就有偶数个元素
                // 如果中点跟左边不同,说明左边没有单一元素,刚好都是配对的
                // 那么左指针指向 mid,目标区域是[mid,right]
                if (nums[mid - 1] != nums[mid]) {
                    left = mid;
                } else {
                    // 反之目标区域在左边,注意已知 mid-1 跟 mid 一样,所以可以跳过
                    // 直接定位 mid-2
                    right = mid - 2;
                }
            } else {
                // 同理
                if (nums[mid - 1] == nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return nums[left];
    }
}
// @lc code=end

