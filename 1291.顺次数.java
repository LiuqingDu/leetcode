/*
 * @lc app=leetcode.cn id=1291 lang=java
 *
 * [1291] 顺次数
 */

// @lc code=start
class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        
        List<Integer> res = new ArrayList<>();
        String s = "123456789";

        // 枚举长度
        for (int len = 2; len <= 9; len++) {
            for (int i = 0; i + len <= 9; i++) {
                String sub = s.substring(i, i + len);
                int num = Integer.parseInt(sub);

                if (num >= low && num <= high) {
                    res.add(num);
                }
            }
        }

        Collections.sort(res);
        return res;
    }
}
// @lc code=end

