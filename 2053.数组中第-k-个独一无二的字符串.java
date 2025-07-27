/*
 * @lc app=leetcode.cn id=2053 lang=java
 *
 * [2053] 数组中第 K 个独一无二的字符串
 */

// @lc code=start
class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> countMap = new HashMap<>();
        for (String str : arr) {
            countMap.put(str, countMap.getOrDefault(str, 0) + 1);
        }

        for (String str : arr) {
            if (countMap.get(str) == 1) {
                k--;
                if (k == 0) {
                    return str;
                }
            }
        }
        return "";
    }
}
// @lc code=end

