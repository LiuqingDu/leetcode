/*
 * @lc app=leetcode.cn id=506 lang=java
 *
 * [506] 相对名次
 */

// @lc code=start
class Solution {
    public String[] findRelativeRanks(int[] score) {
        // 原数组复制一份后排序，然后把排序结果放到Map里
        // 再遍历原数组，从map找到排名放到结果中
        String[] ss = new String[]{"Gold Medal","Silver Medal","Bronze Medal"};
        int n = score.length;
        String[] res = new String[n];
        int[] copy = score.clone();
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            // 注意这里排序后的结果，第一个是数字最小的，也就是排名最后一名
            map.put(copy[i], n - 1 - i);
        }
        for (int i = 0; i < n; i++) {
            int j = map.get(score[i]);
            res[i] = j < 3 ? ss[j] : String.valueOf(j + 1);
        }
        return res;
    }
}
// @lc code=end

