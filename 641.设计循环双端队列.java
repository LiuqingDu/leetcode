/*
 * @lc app=leetcode.cn id=641 lang=java
 *
 * [641] 设计循环双端队列
 */

// @lc code=start
class MyCircularDeque {
    // 用数组实现
    // 从右边存入新数据时对索引取余即可实现连接到左端
    // 从左边为了避免负数,需要先加上数组长度再-1,最后取余

    // 用于存储元素的数组
    private int[] deque;
    // 头指针，指向第一个有效元素的位置
    private int front;
    // 尾指针，指向最后一个有效元素的位置
    private int rear;
    // 当前队列的元素数量
    private int size;
    // 队列的最大容量
    private int capacity;

    public MyCircularDeque(int k) {
        capacity = k;
        deque = new int[capacity];
        // 因为操作时是假定 front 和 rear 都指向已填充数据的地方
        // 向两端插入数据时会先移动指针后插入
        // 为避免漏掉一个位置没有使用, 初始化的时候应当让 front 和 rear 交叉
        // 这里注意理解 rear, 原本交叉的话, rear 可以设置为-1, 这样比较清晰体现出交叉
        // 但是如果测试用例只往 front 插入数据但从 rear 读取,则会出现索引-1 错误
        // 所以这里索引应当加上数组尺寸再求余, 相当于 (-1+k)%k = k-1
        front = 0;
        rear = capacity - 1;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;  // 队列已满，插入失败
        }
        front = (front - 1 + capacity) % capacity;  // 更新头指针位置
        deque[front] = value;  // 插入新元素
        size++;  // 更新队列大小
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;  // 队列已满，插入失败
        }
        rear = (rear + 1) % capacity;  // 更新尾指针位置
        deque[rear] = value;  // 插入新元素
        size++;  // 更新队列大小
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;  // 队列为空，删除失败
        }
        front = (front + 1) % capacity;  // 更新头指针位置
        size--;  // 更新队列大小
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;  // 队列为空，删除失败
        }
        rear = (rear - 1 + capacity) % capacity;  // 更新尾指针位置
        size--;  // 更新队列大小
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;  // 队列为空，返回 -1
        }
        return deque[front];  // 返回头部元素
    }
    
    public int getRear() {
        if (isEmpty()) {
            return -1;  // 队列为空，返回 -1
        }
        return deque[rear];  // 返回尾部元素
    }
    
    public boolean isEmpty() {
        return size == 0;  // 如果元素数量为 0，队列为空
    }
    
    public boolean isFull() {
        return size == capacity;  // 如果元素数量等于容量，队列已满
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
// @lc code=end

