/*
 * @lc app=leetcode.cn id=405 lang=java
 *
 * [405] 数字转换为十六进制数
 */

// @lc code=start
class Solution {
    public String toHex(int num) {
        char[] arr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        // 负数使用补码计算，负数可以理解为0减去一个正数，补码中减法a-b可以变换成a+模-b
        // 其中模就是可容纳的数字的个数
        // 比如一个钟表，模就是12。假设现在需要把表从8点拨到6点
        // 可以后退2小时（-2），也可以前进10小时（12-2），其中12就是模
        // 这样减法可以替换成加法
        // 注意上面用0-b表示负数，所以变换为0+模-b，下面代码中如果n是负数，此时n等于-b，所以后面是+n
        long _num = num;
        if (_num < 0) {
            _num = (1L << 32) + _num;
        }
        while (_num > 0) {
            int i = (int) (_num % 16);
            sb.append(arr[i]);
            _num = _num / 16;
        }
        if (sb.length() == 0) {
            sb.append('0');
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

