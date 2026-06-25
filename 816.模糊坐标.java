/*
 * @lc app=leetcode.cn id=816 lang=java
 *
 * [816] 模糊坐标
 */

// @lc code=start
class Solution {
    public List<String> ambiguousCoordinates(String s) {
        
        List<String> res = new ArrayList<>();
        // 去掉前后的括号
        String sub = s.substring(1, s.length() - 1);
        int n = sub.length();
        
        // i 表示左边 X 坐标数字的长度，至少为 1，右边 Y 坐标也至少剩 1 个字符
        for (int i = 1; i < n; i++) {
            String leftStr = sub.substring(0, i);
            String rightStr = sub.substring(i);
            
            // 获取左边和右边所有合法的数字形态
            List<String> leftList = getValid(leftStr);
            List<String> rightList = getValid(rightStr);
            
            // 双重循环，自由组合
            for (String l : leftList) {
                for (String r : rightList) {
                    res.add("(" + l + ", " + r + ")");
                }
            }
        }
        
        return res;
    }

    // 辅助函数：为一个纯数字字符串寻找所有合法的数字（整数或小数）形态
    private List<String> getValid(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        
        // 1. 尝试作为整数（不加小数点）
        // 如果长度为 1，或者长度大于 1 但不以 '0' 开头，则是合法的整数
        if (n == 1 || s.charAt(0) != '0') {
            ans.add(s);
        }
        
        // 2. 尝试加小数点，i 表示小数点前面的字符个数
        for (int i = 1; i < n; i++) {
            String integerPart = s.substring(0, i); // 整数部分
            String decimalPart = s.substring(i);    // 小数部分
            
            // 判定整数部分：如果长度大于 1，不能以 '0' 开头
            if (integerPart.length() > 1 && integerPart.charAt(0) == '0') {
                continue;
            }
            // 判定小数部分：不能以 '0' 结尾
            if (decimalPart.charAt(decimalPart.length() - 1) == '0') {
                continue;
            }
            
            // 组合成小数
            ans.add(integerPart + "." + decimalPart);
        }
        
        return ans;
    }
}
// @lc code=end

