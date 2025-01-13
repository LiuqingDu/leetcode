/*
 * @lc app=leetcode.cn id=670 lang=java
 *
 * [670] 最大交换
 */

// @lc code=start
class Solution {
    public int maximumSwap(int num) {
        // 贪心法. 从左到右,每一个数字都必须大于等于它右边的每一位数字
        // 也就是右边不能出现比当前位更大的数字
        // 如果不是,那么它需要跟右边的最大且最靠后的数字进行交换
        // 1993->9193->9913->9931


        // 将数字转换成字符数组
        char[] digits = String.valueOf(num).toCharArray();
        int n = digits.length;

        // 记录每个数字最后出现的位置
        int[] last = new int[10];
        for (int i = 0; i < n; i++) {
            last[digits[i] - '0'] = i;
        }

        // 遍历每个数字，尝试和后面的更大的数字交换
        for (int i = 0; i < n; i++) {
            // 从9到当前数字的范围查找是否有更大的数字出现在后面
            for (int d = 9; d > digits[i] - '0'; d--) {
                // 这里 d 是比当前数字大的,如果 d 的位置在当前位置右边
                if (last[d] > i) {
                    // 找到一个更大的数字并且位置在当前数字的后面，进行交换
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;

                    // 交换一次即可，返回结果
                    return Integer.parseInt(new String(digits));
                }
            }
        }

        // 如果没有找到交换的机会，直接返回原数字
        return num;
    }
}
// @lc code=end

