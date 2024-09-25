/*
 * @lc app=leetcode.cn id=89 lang=java
 *
 * [89] 格雷编码
 */

// @lc code=start

class Solution {
    public List<Integer> grayCode(int n) {
        // 在已经有 n 位格雷码序列（记为 Gn）的情况下
        // n+1 位的格雷码序列可以通过下面的步骤获得：
        // 1. 对于 Gn 里每一个数字在二进制前面加 0，记为 Gn'
        // 2. 对于 Gn 倒序，每一个元素二进制前面加 1，记为 Rn
        // 把 Gn‘ 和 Rn 拼接起来得到新的格雷码序列
        // 如：
        // 0, 1
        // 00, 01, 11, 10
        // 000, 001, 011, 010, 110, 111, 101, 100

        ArrayList<Integer> res = new ArrayList<Integer>() {{ add(0); }};
        // 前面拼接的 1，每轮会把 1 向左移动，进行新的一轮拼接
        int head = 1;

        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                // 从末尾往前，每一个都在前面加 1，然后拼接在后面
                res.add(head + res.get(j));
            }
            // 拼接的 1 往左移动一位
            head <<= 1;
        }

        return res;
    }
}
// @lc code=end

