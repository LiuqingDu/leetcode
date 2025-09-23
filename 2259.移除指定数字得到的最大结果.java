/*
 * @lc app=leetcode.cn id=2259 lang=java
 *
 * [2259] 移除指定数字得到的最大结果
 */

// @lc code=start
class Solution {
    public String removeDigit(String number, char digit) {
        // 实际上无论如何都要删除一位
        // 所以可以理解为两位数要变为一位数,三位数要变为两位数
        // 在第一个digit左边的数字都不会变
        // 当遇到一个digit之后,删除它就是用它后面的数字来补这一位
        // 那么如果后边的一位数字比digit更大,那么补上去之后整个数字也是大的
        // 当只有一个digit时,只能删除它
        // 但如果有多个digit,那么从左往右开始,
        // 第一个后边的数字比digit大的,
        // 那么删除这个digit就是最优解
        // 如果没有,那么只能删除最后一个digit
        int n = number.length();
        int ind = -1;

        for (int i = 0; i < n; i++) {
            if (number.charAt(i) == digit) {
                ind = i; 
                if (i < n - 1 && number.charAt(i + 1) > digit) {
                    return number.substring(0, i) + number.substring(i + 1);
                }
            }
        }

        return number.substring(0, ind) + number.substring(ind + 1);
    }
}
// @lc code=end

