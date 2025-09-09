/*
 * @lc app=leetcode.cn id=2194 lang=java
 *
 * [2194] Excel 表中某个范围内的单元格
 */

// @lc code=start
class Solution {
    public List<String> cellsInRange(String s) {
        // 解析起始列、结束列、起始行和结束行
        List<String> result = new ArrayList<>();
        char startCol = s.charAt(0);
        char endCol = s.charAt(3);
        int startRow = s.charAt(1) - '0';
        int endRow = s.charAt(4) - '0';

        for (char col = startCol; col <= endCol; col++) {
            for (int row = startRow; row <= endRow; row++) {
                result.add("" + col + row);
            }
        }
        return result;
    }
}
// @lc code=end

