/*
 * @lc app=leetcode.cn id=1404 lang=java
 *
 * [1404] 将二进制表示减到 1 的步骤数
 */

// @lc code=start
class Solution {
    public int numSteps(String s) {
        
        int steps = 0;
        int carry = 0;
        
        // 从最低位遍历到第二高位（忽略索引 0）
        for (int i = s.length() - 1; i > 0; i--) {
            int currentBit = s.charAt(i) - '0';
            
            if ((currentBit + carry) % 2 == 1) {
                // 奇数情况：加 1 并除以 2，消耗 2 步，并产生进位
                steps += 2;
                carry = 1;
            } else {
                // 偶数情况：直接除以 2，消耗 1 步，进位保持或不变
                steps += 1;
            }
        }
        
        // 最终处理最高位 (s[0] 必然是 '1')
        // 如果有进位，1 + 1 = 10，需要再除以 2，增加 1 步
        return steps + carry;
    }
}
// @lc code=end

