package main.java.com.dsalgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BranchSum {

    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {

        List<Integer> results = new ArrayList<>();
        branchSums(root,results,0);
        return results;
    }

    private static void branchSums(BinaryTree node, List<Integer> results, int runningSum) {
        if (node == null) {
            return;
        }
        int newrunningSum =runningSum + node.value;
        if (node.left==null && node.right ==null){
            results.add(newrunningSum);
        }
        branchSums(node.left,results,newrunningSum);
        branchSums(node.right,results,newrunningSum);
    }

}
