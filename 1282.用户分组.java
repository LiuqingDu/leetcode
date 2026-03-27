/*
 * @lc app=leetcode.cn id=1282 lang=java
 *
 * [1282] 用户分组
 */

// @lc code=start
class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        
        List<List<Integer>> result = new ArrayList<>();
        // key: group size, value: list of people in that group so far
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < groupSizes.length; i++) {
            int size = groupSizes[i];
            map.putIfAbsent(size, new ArrayList<>());
            map.get(size).add(i);
            
            // 当人数达到组大小时，把这一组加入结果，并清空临时列表
            if (map.get(size).size() == size) {
                result.add(new ArrayList<>(map.get(size)));
                map.get(size).clear();
            }
        }
        
        return result;
    }
}
// @lc code=end

