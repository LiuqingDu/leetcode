/*
 * @lc app=leetcode.cn id=1461 lang=java
 *
 * [1461] 检查一个字符串是否包含所有长度为 K 的二进制子串
 */

// @lc code=start
class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        // 1. 计算长度为 k 的二进制总共有多少种组合 (即 2 的 k 次方)
        // 1 << k 是位运算，等价于 Math.pow(2, k)，但速度更快
        int totalCombinations = 1 << k;
        
        // 优化：如果 s 能提供的子串总数连 totalCombinations 都不够，直接返回 false
        if (s.length() - k + 1 < totalCombinations) {
            return false;
        }

        // 2. 用一个 HashSet 来记录 s 中所有出现过的长度为 k 的子串
        HashSet<String> seen = new HashSet<>();

        // 3. 遍历字符串 s，滑动窗口切出所有长度为 k 的子串
        for (int i = 0; i <= s.length() - k; i++) {
            // 切取从 i 开始，长度为 k 的子串
            String sub = s.substring(i, i + k);
            seen.add(sub);
            
            // 如果提前凑齐了所有组合，直接返回 true，省得继续往下走
            if (seen.size() == totalCombinations) {
                return true;
            }
        }

        // 4. 最后检查我们收集到的数量是否等于总组合数
        return seen.size() == totalCombinations;
    }
}
// @lc code=end

