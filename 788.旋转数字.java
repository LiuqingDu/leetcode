/*
 * @lc app=leetcode.cn id=788 lang=java
 *
 * [788] 旋转数字
 */

// @lc code=start
class Solution {
    // -1 表示是 3,4,7
    // 1 表示是 2,5,6,9
    static int[] check = {0, 0, 1, -1, -1, 1, 1, -1, 0, 1};

    public int rotatedDigits(int n) {
        // 一个数是好数，当且仅当：
        // 1. 数中没有出现 3,4,7；
        // 2. 数中至少出现一次 2 或 5 或 6 或 9；
        // 3. 对于 0,1,8 则没有要求。
        // 用 valid 记录数是否满足第一条要求，diff 记录数是否满足第二条要求

        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            String num = String.valueOf(i);
            boolean valid = true, diff = false;
            for (int j = 0; j < num.length(); ++j) {
                char ch = num.charAt(j);
                if (check[ch - '0'] == -1) {
                    valid = false;
                } else if (check[ch - '0'] == 1) {
                    diff = true;
                }
            }
            // 首先需要 valid
            // 其次需要 diff, 因为如果 diff==false, 表明没有出现旋转后改变的数字
            if (valid && diff) {
                ++ans;
            }
        }
        return ans;
    }
}
// @lc code=end

