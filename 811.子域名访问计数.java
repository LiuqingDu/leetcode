/*
 * @lc app=leetcode.cn id=811 lang=java
 *
 * [811] 子域名访问计数
 */

// @lc code=start
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        // 使用 HashMap 来存储每个子域名的访问计数
        // 遍历 cpdomains 数组，分离出访问计数和域名
        // 对于每个域名，计算其所有子域名的访问计数
        // 最后将结果转换为所需的格式并返回
        // 时间复杂度：O(n * m)，其中 n 是 cpdomains 的长度，
        // m 是每个域名的平均长度
        // 空间复杂度：O(n)，用于存储子域名的访问计数
        List<String> ans = new ArrayList<String>();
        Map<String, Integer> counts = new HashMap<String, Integer>();
        for (String cpdomain : cpdomains) {
            int space = cpdomain.indexOf(' ');
            int count = Integer.parseInt(cpdomain.substring(0, space));
            String domain = cpdomain.substring(space + 1);
            counts.put(domain, counts.getOrDefault(domain, 0) + count);
            for (int i = 0; i < domain.length(); i++) {
                if (domain.charAt(i) == '.') {
                    String subdomain = domain.substring(i + 1);
                    counts.put(subdomain, counts.getOrDefault(subdomain, 0) + count);
                }
            }
        }
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            String subdomain = entry.getKey();
            int count = entry.getValue();
            ans.add(count + " " + subdomain);
        }
        return ans;
    }
}
// @lc code=end

