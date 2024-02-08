/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);

            if (map.get(key) == null) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(strs[i]);
        }

        return new ArrayList<List<String>>(map.values());
    }
}
// @lc code=end

