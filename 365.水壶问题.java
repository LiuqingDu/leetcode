/*
 * @lc app=leetcode.cn id=365 lang=java
 *
 * [365] 水壶问题
 */

// @lc code=start
class Solution {
    // 一共有如下 6 种不同的操作
    // 1. x -> y, x 倒入 y 桶直到 x 空或者 y 满
    // 2. y -> x
    // 3.   -> x, 从水龙头把 x 灌满
    // 4.   -> y
    // 5. x ->  , 倒空 x
    // 6. y ->  ,

    // 对于题目，我们关注的是两个桶的总量，它们总和应当等于 target
    // 那么 1 和 2 对总量是没有变化的，这两个操作可以不考虑在计算中
    // 另外我们可以看出，无论如何不会出现两个桶都是有水但不满的情况，
    // 因为无论是哪个操作，最终都会使得至少一个桶处于空或者满的状态
    // 此时我们可以得出一个结论：
    // 每个操作只会让水的总量增加 x 或者增加 y 或者减少 x 或者减少 y
    // 解释：给空桶加满或者把满桶倒掉符合结论的内容
    //      而对于一个有水但不满的桶 a，我们知道另一个桶 b 要么是空要么是满
    //      此时对于这个 a 操作是没有意义的：
    //      我们把 a 加满，就相当于把它从初始空桶状态加满
    //      同理把 a 倒空，相当于让 a 处于初始状态
    // 因此，每个操作只会让总量+/-x或者+/-y
    // 题目可以变为 a*x + b*y = target
    // 是否存在整数 a 和 b 满足等式
    // 其中负数表示倒掉
    // 贝祖定理：a*y + b*y = z 当且仅当 z 是 x, y 的最大公约数的倍数，才有解
    // 因此找出 x 和 y 的最大公约数，判断是否倍数即可
    public boolean canMeasureWater(int x, int y, int target) {
        if (x + y < target) {
            return false;
        }

        if (x == 0 || y == 0) {
            return target == 0 || x + y == target;
        }

        return target % gcd(x, y) == 0;
    }

    private int gcd(int x, int y) {
        int remainder = x % y;
        while (remainder != 0) {
            x = y;
            y = remainder;
            remainder = x % y;
        }
        return y;
    }
}
// @lc code=end

