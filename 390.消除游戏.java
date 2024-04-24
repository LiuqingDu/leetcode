/*
 * @lc app=leetcode.cn id=390 lang=java
 *
 * [390] 消除游戏
 */

// @lc code=start
class Solution {
    public int lastRemaining(int n) {

        // https://leetcode.cn/problems/elimination-game/solutions/1187915/wo-hua-yi-bian-jiu-kan-dong-de-ti-jie-ni-k2uj/
        // 把第一个元素记为head，head表示剩下的队列中第一个元素
        // 只观察这个head，当从左边开始消除的时候，这个head必须要往右移动去寻找下一个元素
        // 当从右边往左消除的时候，左边这个head不一定会动，当此时队列有偶数个的时候，head不需要动
        // 右边往左消除，且队列里有奇数个元素，head就需要移动
        // 当队列里只剩下1个元素的时候，head就是最后剩下的元素

        // 元素从1开始
        int head = 1;
        // 记录每轮消除元素的时候的步长
        int step = 1;
        // 消除的方向，初始为从左边开始
        boolean left = true;
        
        while (n > 1) {
            // 如果从左边开始，或者【右边开始但总数为奇数】
            // 则需要移动head
            if (left || n % 2 != 0) {
                head += step;
            }
            // 步长翻倍，表示跳过上一轮删除的元素，每次删除一半
            step *= 2;
            left = !left;
            n /= 2;
        }

        return head;

    }
}
// @lc code=end

