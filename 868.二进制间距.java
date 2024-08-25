/*
 * @lc app=leetcode.cn id=868 lang=java
 *
 * [868] 二进制间距
 */

// @lc code=start
class Solution {
    public int binaryGap(int n) {
        int res = 0;
        for (int i = 31, j = -1; i >= 0; i--) {
            // 取出从右往左第i位，跟1进行与运算可以保留最后一位
            if (((n >> i) & 1) == 1) {
                if (j != -1) {
                    res = Math.max(res, j - i);
                }
                j = i;
            }
        }
        return res;

    }
}
// @lc code=end

