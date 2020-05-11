package main.java.com.dsalgo;

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {
    public static void invertBinaryTree(BinaryTree tree) {
        Queue<BinaryTree> queue = new ArrayDeque<>();
        queue.add(tree);
        while(!queue.isEmpty()){
            BinaryTree node = queue.remove();
            if (node == null){
                continue;
            }
            swapNodes(node);
            if (node.left != null){
                queue.add(node.left);
            }
            if (node.right!=null) {
                queue.add(node.right);
            }
        }
        // Write your code here.
    }

    private static void swapNodes(BinaryTree node) {
        BinaryTree left = node.left;
        node.left = node.right;
        node.right = left;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
