/*
 * @lc app=leetcode.cn id=1342 lang=java
 *
 * [1342] 将数字变成 0 的操作次数
 */

// @lc code=start
class Solution {
    public int numberOfSteps(int num) {
        // 从二进制来看,就是要最终变为 0, 
        // 那么原数字每有一个 1,就需要执行一次 1 变为 0
        // 原数字有多少位,就需要执行多少次右移
        // 最终次数应该是两个之和,但还要减去 1, 因为剩最后一位 1 变为 0 之后就不需要再移动了

        return Math.max(getLoc(num) + getCnt(num) - 1, 0);
    }
    //  最高位 1 在第几位,也就是数字有多少位
    int getLoc(int x) {
        for (int i = 31; i >= 0; i--) {
            if (((x >> i) & 1) == 1) return i + 1;
        }
        return -1; // never
    }
    // 有多少个 1
    int getCnt(int x) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if (((x >> i) & 1) == 1) ans++;
        }
        return ans;
    }
}
// @lc code=end

