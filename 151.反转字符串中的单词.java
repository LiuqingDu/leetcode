/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
    public String reverseWords(String s) {
        // 思路是先把整个字符串翻转，然后再把每一个单词翻转，就实现了把原单词顺序翻转
        StringBuilder sb = new StringBuilder();
        // 把多于的空格都删掉
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 不是空格的话就直接加到新字符串里
            if (c != ' ') {
                sb.append(c);
            } else if (!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                // 是空格，且新字符串最后一个不是空格，则把这个空格加进去，这样可以避免加入多余的空格
                // 单词之间保留一个空格
                sb.append(' ');
            }
        }
        if (sb.isEmpty()) {
            return "";
        }

        // 末尾有可能有一个多余的空格
        if (sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // 去除多余空格的字符串
        char[] chars = sb.toString().toCharArray();
        int n = chars.length;
        // 进行单词的翻转，先整体翻转
        reverse(chars, 0, n - 1);
        // 再把每个单词翻转
        for (int i = 0; i < n;) {
            for (int j = i; j < n; j++) {
                if (j + 1 == n || chars[j + 1] == ' ') {
                    reverse(chars, i , j);
                    i = j + 2;
                    break;
                }
            }
        }

        return new String(chars);

    }

    // 翻转字符串
    private void reverse(char[] arr, int i, int j) {
        while (i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i++;
            j--;
        }
    }
}
// @lc code=end

