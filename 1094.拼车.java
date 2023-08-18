/*
 * @lc app=leetcode.cn id=1094 lang=java
 *
 * [1094] 拼车
 */

// @lc code=start
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        // 站点编号为[0,1000],总共1001个
        Difference diff = new Difference(new int[1001]);

        for (int i = 0; i < trips.length; i++) {
            // 注意乘客在trip[i][1]站点下车，也就是说车上有人的站点是上一站
            // 在trip[i][1]站的时候，乘客已经不在车上了
            // Difference类的方法increase()第二个参数表示最后有人的站，因此需要-1
            diff.increase(trips[i][1], trips[i][2] - 1, trips[i][0]);
        }
        int[] res = diff.result();

        for (int i = 0; i < res.length; i++) {
            if (res[i] > capacity) {
                return false;
            }
        }
        return true;
    }

    class Difference {
        private int[] diff;
        // 构造差分数组
        public Difference(int[] nums) {
            diff = new int[nums.length];
            diff[0] = nums[0];
            // 根据原数组建立差分数组
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        // 注意这里的if判断，如果j+1已经超出数组，说明是一直修改到最后一个数，那么就不需要再还原回来了
        public void increase(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        public int[] result() {
            int[] res = new int[diff.length];
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
// @lc code=end

