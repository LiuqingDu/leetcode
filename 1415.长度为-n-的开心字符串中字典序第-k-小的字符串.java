/*
 * @lc app=leetcode.cn id=1415 lang=java
 *
 * [1415] 长度为 n 的开心字符串中字典序第 k 小的字符串
 */

// @lc code=start
class Solution {
    public String getHappyString(int n, int k) {
        
        // 第 1 个字符确定后，后面每个分支的组合数
        int groupSize = 1 << (n - 1); 
        
        // 总数超过 k，无法找到
        if (k > 3 * groupSize) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        
        // 1. 确定第一个字符
        if (k <= groupSize) {
            sb.append('a');
        } else if (k <= 2 * groupSize) {
            sb.append('b');
            k -= groupSize;
        } else {
            sb.append('c');
            k -= 2 * groupSize;
        }

        // 2. 逐位确定剩下的 n-1 个字符
        for (int i = 1; i < n; i++) {
            groupSize >>= 1; // 剩余位置的每个分支的组合数减半
            
            char prev = sb.charAt(i - 1);
            // 根据前一个字符，确定当前位可选的“小字母”和“大字母”
            char choices[] = getChoices(prev); 
            
            if (k <= groupSize) {
                sb.append(choices[0]); // 选小的
            } else {
                sb.append(choices[1]); // 选大的
                k -= groupSize;
            }
        }

        return sb.toString();
    }

    // 辅助方法：根据前一个字符，返回当前可选的两个字符（按字典序升序）
    private char[] getChoices(char prev) {
        if (prev == 'a') return new char[]{'b', 'c'};
        if (prev == 'b') return new char[]{'a', 'c'};
        return new char[]{'a', 'b'};
    }
}
// @lc code=end

