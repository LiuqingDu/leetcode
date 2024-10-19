/*
 * @lc app=leetcode.cn id=388 lang=java
 *
 * [388] 文件的最长绝对路径
 */

// @lc code=start
class Solution {
    static int[] hash = new int[10000];
    public int lengthLongestPath(String input) {
        // 初始化hash数组，所有值设置为-1
        Arrays.fill(hash, -1);
        int inputLength = input.length();
        int maxLength = 0;

        // 遍历输入字符串
        for (int i = 0; i < inputLength; i++) {
            int level = 0;

            // 计算当前文件/目录的层级（通过 tab 的数量）
            while (i < inputLength && input.charAt(i) == '\t') {
                level++;
                i++;  // 手动推进 i
            }

            int start = i;
            boolean isDirectory = true;

            // 计算当前文件/目录的名称长度，并判断是否为文件
            while (i < inputLength && input.charAt(i) != '\n') {
                if (input.charAt(i) == '.') {
                    isDirectory = false;  // 有'.'的代表是文件
                }
                i++;  // 手动推进 i
            }

            int currentLength = i - start;
            int previousLength = (level - 1 >= 0) ? hash[level - 1] : -1;
            int fullPathLength = previousLength + 1 + currentLength;  // +1 是为了加上路径的'/'符号

            // 更新目录的长度到hash，或者更新最大路径长度
            if (isDirectory) {
                hash[level] = fullPathLength;  // 记录当前目录的全路径长度
            } else {
                maxLength = Math.max(maxLength, fullPathLength);  // 记录最大文件路径长度
            }

            // 如果当前字符是换行符，i 已经指向 '\n'，所以这里继续前进
        }

        return maxLength;
    }
}
// @lc code=end

