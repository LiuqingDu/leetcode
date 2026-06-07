/*
 * @lc app=leetcode.cn id=1405 lang=java
 *
 * [1405] 最长快乐字符串
 */

// @lc code=start
class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            // 1. 每次循环，先手动找出当前 剩余数量 最多、次多、最少的字母
            char maxCh = 'a', midCh = 'b', minCh = 'c';
            int maxCnt = a, midCnt = b, minCnt = c;
            
            // 简单的两两交换，把 maxCnt 变成最大，midCnt 变成次大
            if (maxCnt < midCnt) {
                // 交换 max 和 mid
                int tCnt = maxCnt; maxCnt = midCnt; midCnt = tCnt;
                char tCh = maxCh; maxCh = midCh; midCh = tCh;
            }
            if (maxCnt < minCnt) {
                // 交换 max 和 min
                int tCnt = maxCnt; maxCnt = minCnt; minCnt = tCnt;
                char tCh = maxCh; maxCh = minCh; minCh = tCh;
            }
            if (midCnt < minCnt) {
                // 交换 mid 和 min
                int tCnt = midCnt; midCnt = minCnt; minCnt = tCnt;
                char tCh = midCh; midCh = minCh; minCh = tCh;
            }
            
            // 如果连数量最多的字母都变成 0 了，说明所有字母都用完了，直接退出
            if (maxCnt == 0) {
                break;
            }
            
            int len = sb.length();
            // 2. 检查最后两个字符是不是已经是 maxCh 了
            if (len >= 2 && sb.charAt(len - 1) == maxCh && sb.charAt(len - 2) == maxCh) {
                // 如果是，为了防止连续 3 个，我们只能被迫选“次多”的 midCh
                if (midCnt == 0) {
                    // 如果连次多的也变成 0 了，说明救不了场了，只能结束
                    break;
                }
                
                sb.append(midCh);
                // 对应的原始变量减 1
                if (midCh == 'a') a--;
                else if (midCh == 'b') b--;
                else c--;
                
            } else {
                // 3. 正常情况，安全！无脑选“最多”的 maxCh 
                sb.append(maxCh);
                // 对应的原始变量减 1
                if (maxCh == 'a') a--;
                else if (maxCh == 'b') b--;
                else c--;
            }
        }
        
        return sb.toString();
    }
}
// @lc code=end

