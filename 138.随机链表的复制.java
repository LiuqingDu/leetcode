/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 随机链表的复制
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        // 第一步，在每个节点后面复制一个它自己，形成a-a'-b-b'...
        // 第二步，对于每一个原节点 a和它的随机指针对应的节点 m，
        //      可以看出 a'的随机指针应当指向 a 的随机指针对应节点 m 的下一个节点，也就是 m‘
        //      也就是对于节点 a，让它的 next 的 random 指向自己的 random 的 next
        // 第三步，把链表拆分成两串

        if (head == null) {
            return null;
        }

        // 第一步
        Node p = head;
        while (p != null) {
            // 复制一个当前节点并插入到后面
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            // p 指向新节点的下一个，也就是第一步的 b 节点
            p = newNode.next;
        }

        // 第二步
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // 第三步
        Node dummy = new Node(-1);
        p = head;
        Node cur = dummy;
        while (p != null) {
            // 把复制出来的节点拼到 cur 上
            cur.next = p.next;
            cur = cur.next;
            // 原先的节点next 指向下一个原节点
            p.next = cur.next;
            p = p.next;
        }

        return dummy.next;
    }
}
// @lc code=end

