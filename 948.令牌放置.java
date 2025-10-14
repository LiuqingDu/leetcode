/*
 * @lc app=leetcode.cn id=948 lang=java
 *
 * [948] 令牌放置
 */

// @lc code=start
class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        // 正面朝上能量换积分
        // 朝下积分换能量
        // 为了积分最多,肯定要选择能量小的换积分
        // 并且在换能量时选择能量大的
        // 那么就要先排序
        // 另外,为了不浪费能量,只要能量够用,就要继续换积分
        // 直到能量不够用了,再换能量
        // 最大积分肯定出现在最后一次换积分之后
        // 而不是换能量之后

        Arrays.sort(tokens); // 先对能量卡排序（从小到大）

        // 定义四个变量：
        int left = 0;                  // 指向最小能量的卡，用来“消耗能量换积分”
        int right = tokens.length - 1; // 指向最大能量的卡，用来“消耗积分换能量”
        int score = 0;                 // 当前积分数量（可用于换能量）
        int maxScore = 0;              // 历史最大积分（最终结果）

        // 循环过程：每次选择最优操作
        while (left <= right) {
            if (power >= tokens[left]) {
                // 当前能量足够，选择能量最小的卡换积分
                power -= tokens[left]; // 消耗能量
                score++;               // 获得1积分
                left++;                // 移动左指针
                maxScore = Math.max(maxScore, score); // 更新最大积分
            } else if (score > 0) {
                // 能量不足，但有积分，可消耗1积分换最大能量的卡
                power += tokens[right]; // 获得能量
                score--;                // 积分减少
                right--;                // 移动右指针
            } else {
                // 既没有足够的能量也没有积分，无法再操作
                break;
            }
        }

        return maxScore; // 返回最大积分
    }
}
// @lc code=end

