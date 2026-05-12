/*
 * @lc app=leetcode.cn id=1338 lang=java
 *
 * [1338] 数组大小减半
 */

// @lc code=start
class Solution {
    public int minSetSize(int[] arr) {
        // 就是优先删除出现次数最多的

        // 1. 统计每个数字出现次数
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 2. 把次数放进数组
        List<Integer> list = new ArrayList<>(map.values());

        // 3. 从大到小排序
        Collections.sort(list, Collections.reverseOrder());

        // 4. 贪心删除
        int removeCount = 0;
        int setSize = 0;
        int half = arr.length / 2;

        for (int count : list) {
            removeCount += count;
            setSize++;

            // 删除到一半就停止
            if (removeCount >= half) {
                return setSize;
            }
        }

        return setSize;
    }
}
// @lc code=end

