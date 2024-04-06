/*
 * @lc app=leetcode.cn id=287 lang=java
 *
 * [287] 寻找重复数
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public int findDuplicate(int[] nums) {

        // 二分法，因为每一个元素都是在[1,n]之间，那么对于一个数字mid, 
        // 小于等于mid的元素的个数应当小于等于mid（可能出现缺失数字的情况）,
        // 如果个数大于mid，说明在[1, mid]之间出现了重复的数字
        // 用二分法逐步去缩小这个重复数字的范围

        // 数字取值范围是[1,n]，这里数组长度是n+1
        int n = nums.length - 1;
        int left = 1, right = n;

        while (left < right) {
            // mid表示把数字分为两部分，看重复数字是在mid的哪一边
            // 如果左边不重复的话，那么小于等于mid的数量应该不会超过mid本身
            int mid = (left + right) / 2;
            int c = (int) Arrays.stream(nums).boxed().filter(a -> a <= mid).count();
            // 如果小于等于mid的数量比mid大，说明在[1,mid]之间有重复数字
            if (c > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;

    }
}
// @lc code=end

