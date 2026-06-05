/*
 * @lc app=leetcode.cn id=1400 lang=java
 *
 * [1400] 构造 K 个回文字符串
 */

// @lc code=start
class Solution {
    public boolean canConstruct(String s, int k) {
        
        // 边界条件1：字符不够分
        if (s.length() < k) {
            return false;
        }

        // 统计每个字符出现的次数（这里用布尔数组记录奇偶性即可）
        // true 表示出现奇数次，false 表示出现偶数次
        boolean[] isOdd = new boolean[26];
        int oddCount = 0;

        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            isOdd[index] = !isOdd[index]; // 状态取反
            
            // 动态更新奇数次字符的总数
            if (isOdd[index]) {
                oddCount++;
            } else {
                oddCount--;
            }
        }

        // 边界条件2：奇数次的字符太多，k个回文串装不下
        return oddCount <= k;
    }
}
// @lc code=end

