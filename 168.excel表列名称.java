/*
 * @lc app=leetcode.cn id=168 lang=java
 *
 * [168] Excel表列名称
 */

// @lc code=start
class Solution {
    public String convertToTitle(int columnNumber) {
        // 其实就是26进制的转换
        // 但这里有一个不同的地方就是，一般进制转换是有一个符号表示0的
        // 也就是说我们是用0-9去转换到0-n进制
        // 比如10进制转换16进制，是用0-9匹配到0-F
        // 这道题不同的地方是，没有0，它直接从1开始，
        // 一位数只能表示1-26，那么我们现在就是把10进制的0-9转换为1-26
        // 所以需要把1-26变为0-25，这样才能跟10进制的起点一致
        // 也就是要把输入的数字-1，
        // 这样余数为0的时候，原数字实际上是1或者27等等，然后0-25分别对应A-Z
        // 所以余数为0用A表示，正好对应原数字1或者27等等

        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            // 减一后才能对齐从0开始匹配
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
// @lc code=end

