/*
 * @lc app=leetcode.cn id=164 lang=java
 *
 * [164] 最大间距
 */

// @lc code=start
class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num: nums) {
            min = Math.min(min,num);
            max = Math.max(max,num);
        }

        if (max == min) {
            return 0;
        }

        // 最大值和最小值之间有n-1个区间
        // 这里除法是向下取整，有可能结果为0，导致后面0做除数，因此这里至少取1
        int bucketSize = Math.max(1, (max - min) / (n - 1));
        // 从最小值开始分割区间，最小值是第一个区间，
        // 那么【最小值+区间长度】就是第二个区间，
        // 由此推下去，比最大值小一点点的数刚好可以跟它之前的数字成为一个区间
        // 唯独最大值它自己跟比它小一点的数不在同一个区间，最大数自己是一个区间
        // 这里就需要区间+1来放这个最大值
        int bucketNum = (max - min) / bucketSize + 1;
        int mins[] = new int[bucketNum];
        int maxs[] = new int[bucketNum];

        Arrays.fill(mins, Integer.MAX_VALUE);
        Arrays.fill(maxs, Integer.MIN_VALUE);

        for (int num: nums) {
            int position = (num - min) / bucketSize;

            mins[position] = Math.min(mins[position], num);
            maxs[position] = Math.max(maxs[position], num);
        }

        int res = 0;
        int preMax = maxs[0];

        for (int i = 1; i < bucketNum; i++) {
            // 因为都是非负数，所以如果max没变的话，说明这个区间没有数字
            if (maxs[i] == Integer.MIN_VALUE) {
                continue;
            }
            res = Math.max(res, mins[i] - preMax);
            preMax = maxs[i];
        }

        return res;
    }
}
// @lc code=end

