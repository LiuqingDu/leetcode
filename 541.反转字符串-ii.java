/*
 * @lc app=leetcode.cn id=541 lang=java
 *
 * [541] 反转字符串 II
 */

// @lc code=start
class Solution {
    public String reverseStr(String s, int k) {
        // 左右指针指向要反转额范围
        // 左指针按2k的速度增长，右指针基于左指针向右移动k-1个，
        // 注意l本身算在k个里，所以移动少一个位置
        // 如果右指针超出了字符串末尾，那么就需要取它跟字符串末尾中的小值
        char[] cs = s.toCharArray();
        int n = s.length();
        for (int l = 0; l < n; l = l + 2 * k) {
            int r = l + k - 1;
            // 实际反转的末尾要跟字符串末尾之间取小
            reverse(cs, l, Math.min(r, n - 1));
        }
        return String.valueOf(cs);
    }

    private void reverse(char[] cs, int l, int r) {
        while (l < r) {
            char tmp = cs[l];
            cs[l] = cs[r];
            cs[r] = tmp;
            l++;
            r--;
        }
    }
}
// @lc code=end

