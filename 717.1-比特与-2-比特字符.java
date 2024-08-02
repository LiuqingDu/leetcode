/*
 * @lc app=leetcode.cn id=717 lang=java
 *
 * [717] 1 比特与 2 比特字符
 */

// @lc code=start
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        // 从第一位开始走，要么走一步要么走两步
        // 如果当前位是1，那么就走两步，表示接下来两位组成一个字符，1开头的只能是两位
        // 如果当前位是0，那么就走一步，表示这一个0作为一个字符，0开头的只能是1位
        // 以倒数第二位为界限，如果正好停在倒数第二位，那么剩下最后一位0就只能是一位字符
        // 另一种可能是刚好因为最后一次的+2步，超出倒数第二位，走到最后一位了，说明最后两位组成一个字符

        int n = bits.length;
        int ind = 0;
        while (ind < n - 1) {
            if (bits[ind] == 1) {
                ind += 2;
            } else {
                ind += 1;
            }
        }
        return ind == n - 1;
    }
}
// @lc code=end

