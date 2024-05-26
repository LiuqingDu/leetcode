/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start
class Solution {
    public boolean isHappy(int n) {
        // 题目里提到了循环，用快慢指针是很简单的方法
        // 如果循环到了1，那么以后就只会是1
        // 如果没有1，那么就是循环到别的数字，
        // 这里其实表明无论如何肯定会出现循环，也就是环
        // 快慢指针找到循环的那个点，也就是两个指针相同的地方
        // 这时如果指向的是1，就是快乐数

        int slow = n, fast = n;
        do {
            slow = squareNum(slow);
            fast = squareNum(squareNum(fast));
        } while (slow != fast);

        return slow == 1;
    }

    // 计算每一位的平方和
    private int squareNum(int n) {
        int res = 0;
        while (n > 0) {
            int bit = n % 10;
            res += bit * bit;
            n = n / 10;
        }
        return res;
    }
}
// @lc code=end

