/*
 * @lc app=leetcode.cn id=1387 lang=java
 *
 * [1387] 将整数按权重排序
 */

// @lc code=start
class Solution {
    public int getKth(int lo, int hi, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = lo; i <= hi; i++) {
            list.add(i);
        }

        Collections.sort(list, (a, b) -> {
            int wa = weight(a);
            int wb = weight(b);

            if (wa != wb) {
                return wa - wb;
            }

            return a - b;
        });

        return list.get(k - 1);
    }

    private int weight(int x) {

        int step = 0;

        while (x != 1) {

            if (x % 2 == 0) {
                x /= 2;
            } else {
                x = 3 * x + 1;
            }

            step++;
        }

        return step;
    }
}
// @lc code=end

