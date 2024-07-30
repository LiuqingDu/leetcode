/*
 * @lc app=leetcode.cn id=706 lang=java
 *
 * [706] 设计哈希映射
 */

// @lc code=start
class MyHashMap {
    int[] arr = new int[1000001];

    public MyHashMap() {
        for (int i = 0; i < this.arr.length; i++) {
            this.arr[i] = -1;
        }
    }
    
    public void put(int key, int value) {
        this.arr[key] = value;
    }
    
    public int get(int key) {
        return this.arr[key];
    }
    
    public void remove(int key) {
        this.arr[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// @lc code=end

