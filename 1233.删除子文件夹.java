/*
 * @lc app=leetcode.cn id=1233 lang=java
 *
 * [1233] 删除子文件夹
 */

// @lc code=start
class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // 排序后,如果一个文件夹B是文件夹A的子文件夹,那么B一定排在A之后
        // 如果A在B的前缀中那么B就是A的子文件夹
        
        Arrays.sort(folder);

        List<String> result = new ArrayList<String>();

        result.add(folder[0]);

        for (int i = 1; i < folder.length; i++) {
            String pre = result.get(result.size() - 1);
            String cur = folder[i];

            if (!cur.startsWith(pre + "/")) {
                result.add(cur);
            }
        }

        return result;

    }
}
// @lc code=end
