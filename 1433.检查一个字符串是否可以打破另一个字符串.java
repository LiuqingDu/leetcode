/*
 * @lc app=leetcode.cn id=1433 lang=java
 *
 * [1433] 检查一个字符串是否可以打破另一个字符串
 */

// @lc code=start
class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        
        // 1. 转换为字符数组并排序
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        
        // 标记：假设 s1 可以打破 s2，以及 s2 可以打破 s1
        boolean s1BreaksS2 = true;
        boolean s2BreaksS1 = true;
        
        // 2. 同步遍历对比
        for (int i = 0; i < ch1.length; i++) {
            // 如果出现 s1 的字符小于 s2，说明 s1 不可能打破 s2 了
            if (ch1[i] < ch2[i]) {
                s1BreaksS2 = false;
            }
            // 如果出现 s2 的字符小于 s1，说明 s2 不可能打破 s1 了
            if (ch2[i] < ch1[i]) {
                s2BreaksS1 = false;
            }
            
            // 优化剪枝：如果两者都不可能了，直接提前返回 false
            if (!s1BreaksS2 && !s2BreaksS1) {
                return false;
            }
        }
        
        // 3. 只要有一种情况成立，就返回 true
        return true;
    }
}
// @lc code=end

