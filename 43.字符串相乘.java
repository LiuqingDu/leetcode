/*
 * @lc app=leetcode.cn id=43 lang=java
 *
 * [43] 字符串相乘
 */

// @lc code=start
class Solution {
    public String multiply(String num1, String num2) {
        // 记两个数字字符串的长度为 m 和 n，各自有索引为 i 和 j
        // 相乘结果最多为 m+n 位
        // 看竖式相乘的过程
        // 其中 num1[i] 和 num2[j] 位相乘的结果看做是两位数
        // 分别在索引 i+j 和 i+j+1 上
        // 把每个位上的所有两位结果都加起来就是最终结果
        // 累加过程中会产生进位，所以从最右边向左处理，把进位放在左边等待下一次计算

        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length() - 1; i >= 0; i--) {
            // 从右边取出 num1 一位
            int n1 = num1.charAt(i) - '0';

            for (int j = num2.length() - 1; j >= 0; j--) {
                // 从右边取出 num2 一位
                int n2 = num2.charAt(j) - '0';

                // 乘积应该在 i+j 和 i+j+1 这两位上
                // 把右边位置上的累加到乘积上，然后算出个位数放在右边
                // 结果的十位数累加到左边
                int sum = res[i + j + 1] + n1 * n2;
                res[i + j + 1] = sum % 10;
                res[i + j] += sum / 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if (i == 0 && res[i] == 0) {
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }
}
// @lc code=end

