/*
 * @lc app=leetcode.cn id=1974 lang=java
 *
 * [1974] 使用特殊打字机键入单词的最少时间
 */

// @lc code=start
class Solution {
    public int minTimeToType(String word) {
        // 每一个字母都要被打一次
        // 两个字母之间移动的时间是两个字母的 ASCII 码之差的绝对值
        // 初始位置是 'a'
        int time = 0;
        char prev = 'a';
        for (char c : word.toCharArray()) {
            // 计算当前字母和上一个字母之间的时间, 注意是圆环,可以选择近的方向
            int diff = Math.abs(c - prev);
            int distance = Math.min(diff, 26 - diff);
            // 累加时间
            time += distance;
            // 每打一个字母都需要加上打字的时间
            time += 1;
            // 更新上一个字母
            prev = c;
        }
        // 返回总时间
        return time;
    }
}
// @lc code=end

