/*
 * @lc app=leetcode.cn id=393 lang=java
 *
 * [393] UTF-8 编码验证
 */

// @lc code=start
class Solution {
    // 一字节字符的最大起始值 (10000000), 超过此值说明是多字节字符
    int one = 128;   // 10000000

    // 两字节字符的起始值 (11000000), 超过此值说明是可能的两字节或更长字符
    int two = 192;   // 11000000

    // 三字节字符的起始值 (11100000), 超过此值说明是可能的三字节或更长字符
    int three = 224; // 11100000

    // 四字节字符的起始值 (11110000), 超过此值说明是可能的四字节字符
    int four = 240;  // 11110000

    // 无效的起始字节 (11111000), 超过此值则不是合法的 UTF-8 编码
    int five = 248;  // 11111000
    
    public boolean validUtf8(int[] data) {
        int i = 0;

        // 循环遍历输入数据数组
        while (i < data.length) {

            // 如果当前字节的值大于或等于 248，说明不合法，直接返回 false
            if (data[i] >= five) {
                return false;

            // 如果当前字节的值在四字节范围内，检查接下来的 3 个字节是否符合规范
            } else if (data[i] >= four) {
                // 确保剩下的字节数足够，并且后续字节是有效的次字节
                if (i + 3 >= data.length
                        || invalidSecondary(data[i + 1])
                        || invalidSecondary(data[i + 2])
                        || invalidSecondary(data[i + 3])
                ) {
                    return false;  // 如果条件不符合，返回 false
                }
                i += 4;  // 跳过当前四字节字符

            // 如果当前字节的值在三字节范围内，检查接下来的 2 个字节是否符合规范
            } else if (data[i] >= three) {
                // 确保剩下的字节数足够，并且后续字节是有效的次字节
                if (i + 2 >= data.length
                        || invalidSecondary(data[i + 1])
                        || invalidSecondary(data[i + 2])
                ) {
                    return false;  // 如果条件不符合，返回 false
                }
                i += 3;  // 跳过当前三字节字符

            // 如果当前字节的值在两字节范围内，检查接下来的 1 个字节是否符合规范
            } else if (data[i] >= two) {
                // 确保剩下的字节数足够，并且后续字节是有效的次字节
                if (i + 1 >= data.length
                        || invalidSecondary(data[i + 1])
                ) {
                    return false;  // 如果条件不符合，返回 false
                }
                i += 2;  // 跳过当前两字节字符

            // 如果当前字节的值在单字节范围内且不符合 UTF-8 规范，返回 false
            } else if (data[i] >= one) {
                return false;

            // 如果是单字节字符 (ASCII 范围内)，直接跳到下一个字节
            } else {
                i++;
            }
        }
        return true;  // 如果所有字节都合法，返回 true
    }

    // 检查是否为有效的次字节（次字节应在 10000000 到 11000000 之间）
    private boolean invalidSecondary(int n) {
        return !(n >= one && n < two);
    }
}
// @lc code=end

