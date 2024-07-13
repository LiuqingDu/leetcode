/*
 * @lc app=leetcode.cn id=599 lang=java
 *
 * [599] 两个列表的最小索引总和
 */

// @lc code=start
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        // 把list1放到map里，然后用list2去map里找
        // 有相同的就算一下索引和，比较出最小的索引和即可
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }

        List<String> res = new LinkedList<>();
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int j = map.get(list2[i]);
                // 如果新的索引和更小则清空之前的res，并更新sum
                if (i + j < sum) {
                    res.clear();
                    res.add(list2[i]);
                    sum = i + j;
                } else if (i + j == sum) {
                    res.add(list2[i]);
                }
            }
        }
        return res.toArray(new String[res.size()]);
    }
}
// @lc code=end

