/*
 * @lc app=leetcode.cn id=1556 lang=java
 *
 * [1556] 千位分隔数
 */

// @lc code=start
class Solution {
    public String thousandSeparator(int n) {
        int count = 0;
        StringBuffer ans = new StringBuffer();
        do {
            int cur = n % 10;
            n /= 10;
            ans.append(cur);
            ++count;
            if (count % 3 == 0 && n != 0) {
                ans.append('.');
            }
        } while (n != 0);
        ans.reverse();
        return ans.toString();
    }
}
// @lc code=end

