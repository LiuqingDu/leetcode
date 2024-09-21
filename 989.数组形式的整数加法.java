/*
 * @lc app=leetcode.cn id=989 lang=java
 *
 * [989] 数组形式的整数加法
 */

// @lc code=start
class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // 从右往左计算，只要 num 或者 k 还有数字没有算完，就不停止
        // 初始化每轮的初始值为进位值，有 num 就加 num，有 k 就加 k
        // 这样不需要考虑 num 或者 k 已经算完的情况，算完就相当于 0 处理了
        List<Integer> res = new ArrayList<>();
        int i = num.length - 1;
        int carry = 0;

        while (i >= 0 || k > 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num[i];
                i--;
            }
            if (k > 0) {
                sum += k % 10;
                k /= 10;
            }
            res.add(0, sum % 10);
            carry = sum / 10;
        }

        return res;
    }
}
// @lc code=end

