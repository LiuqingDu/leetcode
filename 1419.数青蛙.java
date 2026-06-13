/*
 * @lc app=leetcode.cn id=1419 lang=java
 *
 * [1419] 数青蛙
 */

// @lc code=start
class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        
        // 5个计数器，分别代表 c, r, o, a, k 状态的青蛙数量
        int c = 0, r = 0, o = 0, a = 0, k = 0;
        int maxFrogs = 0; // 记录历史上同时存在的最大青蛙数

        for (char ch : croakOfFrogs.toCharArray()) {
            if (ch == 'c') {
                if (k > 0) {
                    k--; // 有闲置的青蛙，直接复用
                } else {
                    maxFrogs++; // 没有闲置的，必须召集一只新青蛙
                }
                c++;
            } else if (ch == 'r') {
                if (c == 0) return -1; // 没有唱完 c 的青蛙，顺序错误
                c--;
                r++;
            } else if (ch == 'o') {
                if (r == 0) return -1;
                r--;
                o++;
            } else if (ch == 'a') {
                if (o == 0) return -1;
                o--;
                a++;
            } else if (ch == 'k') {
                if (a == 0) return -1;
                a--;
                k++; // 这只青蛙唱完了，进入闲置状态
            } else {
                return -1; // 出现了 'c','r','o','a','k' 以外的非法字符
            }
        }

        // 遍历结束，检查是否有青蛙歌唱到一半中断了（比如只有 "croa"）
        if (c == 0 && r == 0 && o == 0 && a == 0) {
            return maxFrogs;
        } else {
            return -1;
        }
    }
}
// @lc code=end

