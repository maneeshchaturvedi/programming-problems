package main.java.com.dsalgo;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class BFT {

    static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void breadhFirst(Node root) {
        if (root == null){
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(root);
        while (!queue.isEmpty()){
            Node current = queue.remove();
            System.out.println(current.value);
            queue.add(current.left);
            queue.add(current.right);
        }
    }
    public void depthFirst(Node root) {
        if (root == null){
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node current =stack.pop();
            System.out.println(current.value);
            stack.push(current.left);
            stack.push(current.right);
        }
    }


}
