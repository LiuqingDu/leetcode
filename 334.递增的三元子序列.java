/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        // https://leetcode.cn/problems/increasing-triplet-subsequence/solutions/535725/pou-xi-ben-zhi-yi-wen-bang-ni-kan-qing-t-3ye2/
        // 假设这个三元子序列记为[a,b,c]
        // 假设已经找到a和b，那么对于一个新的数字，它作为c有三种可能
        //  1. c比b大，那么就是找到了满足要求的三元组，返回true
        //  2. c在a和b之间，那么可以用c来替换b，来降低未来组成三元组的门槛，此时b更小了，未来对于c的需求更低了
        //  3. c比a小，那么可以用c来更新a，但是不动b。这里注意，b作为第二个数，它包含这样一层信息：前面有一个数比b小。
        //      这里只更新a，表示第一个数可以取一个更小的值，那么未来对于b和c的要求降低了。
        //      不更新b是表示，b之前有一个数比b小，已经有一个二元组了，只要未来有一个比b大的，就能组成
        //      此时a表示，虽然已经有一个二元组了，但是现在有一个更小的a。如果未来有一个比b小的数，那么就可以跟这个a组成一个更小的二元组

        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num > b) {
                return true;
            } else if (num < b && num > a) {
                b = num;
            } else if (num < a) {
                a = num;
            }
        }

        return false;

    }
}
// @lc code=end

