/*
 * @lc app=leetcode.cn id=838 lang=java
 *
 * [838] 推多米诺
 */

// @lc code=start
class Solution {
    public String pushDominoes(String dominoes) {
        // 对于每一个骨牌, 它的最终状态由最初状态决定
        // 它找到它左侧第一个倒下的牌和右侧第一个倒下的牌
        // 哪边的牌距离更近, 它就倒向哪边
        // 注意它左侧只会受到R的影响, 右侧只会受到L的影响
        // 因此如果左侧第一个倒下的牌是L,则记为距离无穷大
        // 同理如果右侧第一个倒下的牌是R,则记为距离无穷大
        
        // 使用两个数组分别记录每个骨牌到左侧第一个倒下牌和右侧第一个倒下牌的距离
        int n = dominoes.length();
        int[] left = new int[n];
        int[] right = new int[n];
        
        // 计算到左边第一个倒下牌的距离
        // i 表示当前骨牌的索引
        // j 表示左侧第一个倒下牌的索引
        for (int i = 0, j = -1; i < n; i++) {
            // 如果遇到R, 更新j为当前索引
            // 如果遇到L, 则j置为-1, 表示无穷大
            if (dominoes.charAt(i) == 'R') {
                j = i;
            } else if (dominoes.charAt(i) == 'L') {
                j = -1;
            }
            // 计算当前骨牌到左边第一个倒下骨牌的距离
            left[i] = j == -1 ? Integer.MAX_VALUE : i - j;
        }
        
        // 计算到右边第一个L的距离
        for (int i = n - 1, j = -1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                j = i;
            } else if (dominoes.charAt(i) == 'R') {
                j = -1;
            }
            right[i] = j == -1 ? Integer.MAX_VALUE : j - i;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            // 比较左侧和右侧的距离
            // 如果左侧距离小于右侧距离, 则向右倒
            // 如果右侧距离小于左侧距离, 则向左倒
            // 如果两者相等, 则不倒
            if (left[i] < right[i]) {
                result.append('R'); // 向右倒
            } else if (left[i] > right[i]) {
                result.append('L'); // 向左倒
            } else {
                result.append(dominoes.charAt(i)); // 不倒
            }
        }
        
        return result.toString();
    }
}
// @lc code=end

