/*
 * @lc app=leetcode.cn id=473 lang=java
 *
 * [473] 火柴拼正方形
 */

// @lc code=start
class Solution {
    public boolean makesquare(int[] matchsticks) {
        // dfs
        // 尝试将当前火柴依次放入四个边, 看是否满足
        // 对火柴从大到小排序可以提前跳出不满足的组合

        int totalLength = 0;
        for (int match : matchsticks) {
            totalLength += match;
        }
        
        // 如果总长度不是4的倍数，无法组成正方形
        if (totalLength % 4 != 0) {
            return false;
        }
        
        int sideLength = totalLength / 4; // 每条边的目标长度
        
        // 将火柴按长度降序排序，优先放最长的火柴，便于剪枝
        // 排序后倒序
        Arrays.sort(matchsticks);
        for (int i = 0; i < matchsticks.length / 2; i++) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[matchsticks.length - 1 - i];
            matchsticks[matchsticks.length - 1 - i] = temp;
        }
        
        // 用一个数组表示四条边的当前长度
        int[] sides = new int[4];
        return dfs(matchsticks, 0, sides, sideLength);
    }

    private boolean dfs(int[] matchsticks, int index, int[] sides, int target) {
        // 如果所有火柴都放置完毕，检查是否满足条件
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target &&
                   sides[2] == target && sides[3] == target;
        }
        
        // 当前火柴的长度
        int currentMatch = matchsticks[index];
        
        // 尝试将当前火柴放到四条边中的某一条
        for (int i = 0; i < 4; i++) {
            // 如果当前边加上火柴后长度超过目标长度，跳过
            if (sides[i] + currentMatch > target) {
                continue;
            }
            
            // 将火柴放到第 i 条边
            sides[i] += currentMatch;
            
            // 递归尝试放下一根火柴
            if (dfs(matchsticks, index + 1, sides, target)) {
                return true;
            }
            
            // 回溯，撤销当前火柴的放置
            sides[i] -= currentMatch;
            
            // 剪枝：如果当前边为0，说明这一轮放置无效，直接跳过剩余的边
            if (sides[i] == 0) {
                break;
            }
        }
        
        return false; // 无法放置当前火柴
    }
}
// @lc code=end

