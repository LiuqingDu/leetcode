/*
 * @lc app=leetcode.cn id=672 lang=java
 *
 * [672] 灯泡开关 Ⅱ
 */

// @lc code=start
class Solution {
    public int flipLights(int n, int presses) {
        // 因为操作顺序不影响结果，
        // 且开关1+开关2=开关3，
        // 开关1+开关3=开关2，
        // 开关2+开关3=开关1，
        // 相同两次操作等于没有操作，
        // 通过这种抵消方式，可以得到，
        // 当n大于等于3，presses大于等于3时，
        // 最终状态只有以下8种：
        // 初始状态，开关1，开关2，开关3，开关4，
        // 开关1+开关4，开关2+开关4，开关3+开关4。
        // n小于3的情况也可以简单推算出来。

        if (presses == 0) return 1; // 没有按下按钮，只有一种状态
        if (n == 1) return 2; // 只有一个灯泡，按一次可以有两种状态
        if (n == 2) return presses == 1 ? 3 : 4; // 两个灯泡，按一次有 3 种状态，按多次最多 4 种状态
        if (presses == 1) return 4; // 至少 3 盏灯，按一次最多 4 种状态
        if (presses == 2) return 7; // 按两次最多 7 种状态
        return 8; // 按三次及以上最多 8 种状态
    }
}
// @lc code=end

