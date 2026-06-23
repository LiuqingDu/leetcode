/*
 * @lc app=leetcode.cn id=777 lang=java
 *
 * [777] 在 LR 字符串中交换相邻字符
 */

// @lc code=start
class Solution {
    public boolean canTransform(String start, String result) {
        
        int n = start.length();
        int i = 0, j = 0;
        
        while (i < n || j < n) {
            // 1. 忽略 start 中的 'X'
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            // 2. 忽略 result 中的 'X'
            while (j < n && result.charAt(j) == 'X') {
                j++;
            }
            
            // 如果其中一个遍历完了，另一个也必须遍历完（因为 L 和 R 的数量必须相等）
            if (i == n || j == j) {
                return i == n && j == n;
            }
            
            // 3. 此时 i 和 j 指向的都不是 'X'，检查字符是否相同
            if (start.charAt(i) != result.charAt(j)) {
                return false;
            }
            
            // 4. 检查移动方向是否合法
            // 如果是 'L'，在 start 中的位置 i 不能小于在 result 中的位置 j
            if (start.charAt(i) == 'L' && i < j) {
                return false;
            }
            // 如果是 'R'，在 start 中的位置 i 不能大于在 result 中的位置 j
            if (start.charAt(i) == 'R' && i > j) {
                return false;
            }
            
            // 5. 匹配成功，继续看下一个字符
            i++;
            j++;
        }
        
        return true;
    }
}
// @lc code=end

