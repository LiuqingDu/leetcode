/*
 * @lc app=leetcode.cn id=1432 lang=java
 *
 * [1432] 改变一个整数能得到的最大差值
 */

// @lc code=start
class Solution {
    public int maxDiff(int num) {
        
        String s = String.valueOf(num);
        
        // 1. 求最大值 a
        String aStr = s;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '9') {
                // 找到第一个不是 '9' 的字符，全部替换成 '9'
                aStr = s.replace(ch, '9');
                break;
            }
        }
        
        // 2. 求最小值 b
        String bStr = s;
        if (s.charAt(0) != '1') {
            // 如果最高位不是 '1'，把最高位这个数字全部换成 '1'
            bStr = s.replace(s.charAt(0), '1');
        } else {
            // 如果最高位已经是 '1'，从第二位开始找第一个既不是 '0' 也不不是 '1' 的数字
            for (int i = 1; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch != '0' && ch != '1') {
                    // 全部替换成 '0'
                    bStr = s.replace(ch, '0');
                    break;
                }
            }
        }
        
        // 3. 计算差值
        return Integer.parseInt(aStr) - Integer.parseInt(bStr);
    }
}
// @lc code=end

