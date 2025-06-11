/*
 * @lc app=leetcode.cn id=1903 lang=java
 *
 * [1903] 字符串中的最大奇数
 */

// @lc code=start
class Solution {
    public String largestOddNumber(String num) {
        // 奇数就是个数位也就是最右位是奇数
        // 从 num 的右侧往左找,遇到奇数就当做备选数字的起点
        // 因为 num 只有数字,所以从右边找到的第一个奇数开始直到最左侧就是最大数字

        // 从最后一位开始向前找
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            // 判断是否为奇数
            if ((c - '0') % 2 == 1) {
                // 返回从头到当前奇数位的子串
                return num.substring(0, i + 1);
            }
        }
        // 没有找到奇数位，返回空字符串
        return "";
    }
}
// @lc code=end

