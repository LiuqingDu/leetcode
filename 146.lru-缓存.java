/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {
    // 用LinkedHashMap作为核心数据结构，既有HashMap的get的O(1)又有LinkedList的put的O(1)
    // 从链表角度来看，链表头部是最旧的使用的，链表尾部是最新使用的，
    // 更新使用记录可以直接删掉旧的，然后再添加一次就会在队伍末尾
    LinkedHashMap<Integer, Integer> cache;
    // 记录允许的最大容量
    int cap;

    public LRUCache(int capacity) {
        this.cap = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity);
    }
    
    public int get(int key) {
        // 如果不存在则返回-1
        if (!cache.containsKey(key)) {
            return -1;
        }
        // LRU需要更新使用的顺序，刚用过的要更新到最近使用顶部
        makeRecent(key);
        return cache.get(key);
    }
    
    public void put(int key, int value) {
        // 如果存在则更新，并且更新最近使用顶部
        // 这里也可以删掉再添加
        if (cache.containsKey(key)) {
            cache.put(key, value);
            makeRecent(key);
            return;
        }
        // 不存在就要往队列里添加，先看看队列是不是满了，满了就要删掉头部的
        if (this.cap == cache.size()) {
            // 使用keySet的迭代器获取第一个key
            int last = cache.keySet().iterator().next();
            // 删除第一个元素
            cache.remove(last);
        }
        cache.put(key, value);
    }

    // 把已存在的一个值放在队列末尾，表示是最新使用的，
    // 实际的实现是删掉再添加
    private void makeRecent(int key) {
        int val = cache.get(key);
        cache.remove(key);
        cache.put(key, val);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

