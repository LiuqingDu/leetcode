/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {

        // 从最后一位开始，如果是9则涉及进位，进位后循环处理下一位
        // 如果不是9，则不需要进位，当前位置+1即可，然后可以直接返回
        // 这里只会一直循环到第一个不是9的数字为止，再往前就不需要处理了
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i]++;
                return digits;
            }
        }

        // 到这里说明原数字每一位都是9，那么就需要增加一位，首位为1，其余为0
        int[] res = new int[digits.length + 1];
        res[0] = 1;

        return res;

    }
}
// @lc code=end

