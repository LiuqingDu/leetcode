/*
 * @lc app=leetcode.cn id=297 lang=java
 *
 * [297] 二叉树的序列化与反序列化
 */

// @lc code=start

import java.util.LinkedList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // 前序遍历和后续遍历都可以，但中序遍历不可以，因为无法通过字符串确定根节点位置

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        // 如果节点是null则用#表示
        if (node == null) {
            sb.append("#").append(",");
            return;
        }

        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<String>();
        for (String s: data.split(",")) {
            nodes.add(s);
        }
        return deserialize(nodes);
    }

    // list是原字符串用","分割后的，每次取出第一个值为根节点
    // 剩下的部分，前部分是左子树，后部分是右子树
    // 因为每次是把最前面的取出并删除，所以当左子树都生成完了以后，剩下的nodes就全是右子树了
    // 该方法接收一个节点list，生成对应的树
    private TreeNode deserialize(LinkedList<String> nodes) {
        // 如果列表已经为空，那么就没有树了
        if (nodes.size() == 0) {
            return null;
        }

        // 取出第一个值作为根节点，第一个值也从列表中删掉，这样保证后续操作第一个都是根节点
        // 当遇到第一个#时，说明最左侧的树已经到头了，该出现第一个右节点了，这样就会回到上一层，
        // 然后继续执行上一层的生成右子树
        String rootVal = nodes.removeFirst();
        // 如果是null节点则返回
        if (rootVal.equalsIgnoreCase("#")) {
            return null;
        }

        // 生成当前根节点
        TreeNode root = new TreeNode(Integer.parseInt(rootVal));
        // 剩下的前部分是左子树，如果还有右子树，那么下面这个方法只会消耗掉左子树的部分，
        // 因为会有足够多的”#“（null节点）来让方法回到这一层，保证剩下的字符是右子树的
        root.left = deserialize(nodes);
        // 剩下的字符生成右子树
        root.right = deserialize(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
// @lc code=end

