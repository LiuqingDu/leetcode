/*
 * @lc app=leetcode.cn id=1189 lang=java
 *
 * [1189] “气球” 的最大数量
 */

// @lc code=start
class Solution {
    public int maxNumberOfBalloons(String text) {
        // 先统计目标单词的字母需求量
        // 然后统计 text 的字母量
        // 计算每个字母可以满足多少份目标单词的用量
        // 最小的份数就是答案
        // 注意处理目标量为 0 的情况,避免除数为 0
        int[] target = new int[26];
        String str = "balloon";
        for (char c : str.toCharArray()) {
            target[c - 'a']++;
        }

        int[] arr = new int[26];
        for (char c : text.toCharArray()) {
            arr[c - 'a']++;
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (target[i] > 0) {
                res = Math.min(res, arr[i] / target[i]);
            }
        }
        
        return res;
    }
}
// @lc code=end

