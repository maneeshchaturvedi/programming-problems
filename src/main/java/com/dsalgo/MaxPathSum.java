package main.java.com.dsalgo;

import java.util.Calendar;
import java.util.Date;

public class MaxPathSum {
    public static int maxPathSum(BinaryTree tree) {
        // Write your code here.
        Sums sums = findMaxPathSum(tree);
        return Math.max(sums.maxSumAsTree,sums.maxSumAsBranch);
    }

    private static Sums findMaxPathSum(BinaryTree tree) {
        if(tree == null){
            return new Sums(0,0);
        }
        Sums leftSums = findMaxPathSum(tree.left);
        Sums rightSums = findMaxPathSum(tree.right);
        int maxChildSumAsBranch = Math.max(leftSums.maxSumAsBranch,rightSums.maxSumAsBranch);
        int maxSumAsBranch = Math.max(maxChildSumAsBranch+tree.value,tree.value);
        int maxSumAsRoot = Math.max(maxSumAsBranch,leftSums.maxSumAsBranch+tree.value+rightSums.maxSumAsBranch);
        int maxPathSum = Math.max(leftSums.maxSumAsTree,Math.max(rightSums.maxSumAsTree,maxSumAsRoot));
        return new Sums(maxSumAsBranch,maxPathSum);
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class Sums {
        public Sums(int maxSumAsBranch,int maxSumAsTree){
            this.maxSumAsTree = maxSumAsTree;
            this.maxSumAsBranch = maxSumAsBranch;
        }
        public int maxSumAsBranch;
        public int maxSumAsTree;
    }
}


