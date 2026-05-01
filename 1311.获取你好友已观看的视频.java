/*
 * @lc app=leetcode.cn id=1311 lang=java
 *
 * [1311] 获取你好友已观看的视频
 */

// @lc code=start
class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;

        // 1. BFS 找第 level 层
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(id);
        visited[id] = true;

        int currLevel = 0;

        while (!queue.isEmpty() && currLevel < level) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int person = queue.poll();

                for (int f : friends[person]) {
                    if (!visited[f]) {
                        visited[f] = true;
                        queue.offer(f);
                    }
                }
            }

            currLevel++;
        }

        // 2. 统计视频频率
        Map<String, Integer> map = new HashMap<>();

        for (int person : queue) {
            for (String video : watchedVideos.get(person)) {
                map.put(video, map.getOrDefault(video, 0) + 1);
            }
        }

        // 3. 排序
        List<String> result = new ArrayList<>(map.keySet());

        Collections.sort(result, (a, b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);

            if (freqA != freqB) {
                return freqA - freqB; // 频率升序
            }
            return a.compareTo(b); // 字母升序
        });

        return result;
    }
}
// @lc code=end

