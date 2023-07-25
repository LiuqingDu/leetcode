/*
 * @lc app=leetcode.cn id=28 lang=java
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start
class Solution {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();

        // 从第一位开始比较
        for (int i = 0; i <= h - n; i++) {
            int j = 0;
            while(j < n) {
                // 注意是用索引 [i+j] 跟 [j]相比
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
                j++;
            }
            // 如果顺利比较成功，则肯定是因为j==n到达这里的
            // 如果是因为拼配失败 break 到这里，那么一定还满足j<n的条件
            if (j == n) {
                return i;
            }
        }
        return -1;
    }
}
// @lc code=end

