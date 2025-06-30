/*
 * @lc app=leetcode.cn id=822 lang=java
 *
 * [822] 翻转卡片游戏
 */

// @lc code=start
class Solution {
    public int flipgame(int[] fronts, int[] backs) {
        // 如果一个卡片正反两面相同,则这个数字不能作为答案
        // 如果相同数字出现在两张卡片上则不影响
        // 那么我们只要统计同一张卡片正反相同的数字
        // 然后在所有的数字当中先排除这些数字,剩下的数字中最小的就是答案
        // 如果所有的数字都相同,则返回0
        // 使用一个set来存储正反面相同的数字
        Set<Integer> same = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) {
                same.add(fronts[i]);
            }
        }
        // 遍历所有的数字,找到最小的不是相同数字的数字
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < fronts.length; i++) {
            if (!same.contains(fronts[i])) {
                min = Math.min(min, fronts[i]);
            }
        }
        for (int i = 0; i < backs.length; i++) {
            if (!same.contains(backs[i])) {
                min = Math.min(min, backs[i]);
            }
        }
        // 如果最小的数字还是初始值,则说明所有的数字都相同
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
// @lc code=end

