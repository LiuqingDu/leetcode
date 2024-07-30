/*
 * @lc app=leetcode.cn id=705 lang=java
 *
 * [705] 设计哈希集合
 */

// @lc code=start
class MyHashSet {

    boolean[] arr;
    public MyHashSet() {
        this.arr = new boolean[1000001];
    }
    
    public void add(int key) {
        this.arr[key] = true;
    }
    
    public void remove(int key) {
        this.arr[key] = false;
    }
    
    public boolean contains(int key) {
        return this.arr[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

