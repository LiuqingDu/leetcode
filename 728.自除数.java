/*
 * @lc app=leetcode.cn id=728 lang=java
 *
 * [728] 自除数
 */

// @lc code=start
class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new LinkedList<>();
        for (int i = left; i <= right; i++) {
            if (isDividing(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private boolean isDividing(int num) {
        int tmp = num;
        while (tmp > 0) {
            int digit = tmp % 10;
            if (digit == 0 || num % digit != 0) {
                return false;
            }
            tmp = tmp / 10;
        }
        return true;
    }
}
// @lc code=end

