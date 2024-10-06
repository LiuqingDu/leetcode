/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // 先用 map 存储每个数字的出现次数
        // 然后把次数当做下标索引，把数字放到数组对应位置
        // 从数组末尾往前取 k 个数字

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        // 数组从 0 开始，长度比 nums 长度多 1，每一个元素是一个 list，存放多个次数相同的数字
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);
            if (list[i] == null) {
                list[i] = new ArrayList<Integer>();
            }
            list[i].add(key);
        }

        int[] res = new int[k];
        int count = 0;
        for (int i = list.length - 1; i >= 0; i--) {
            if (list[i] == null) {
                continue;
            }
            List<Integer> subList = list[i];
            for (int j = 0; j < subList.size(); j++) {
                int key = subList.get(j);
                if (count < k) {
                    res[count] = key;
                    count++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

