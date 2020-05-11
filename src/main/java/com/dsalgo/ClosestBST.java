package main.java.com.dsalgo;

public class ClosestBST {

    public static int findClosestValueInBst(BST tree, int target) {
        int leastDiff = Integer.MAX_VALUE;
        BST current = tree;
        BST least = tree;
        while (current != null) {
            int diff = Math.abs(target - current.value);
            if(diff < leastDiff){
                leastDiff = diff;
                least = current;
            }
            if (current.value < target) {
                current =current.right;
            }else {
                current =current.left;
            }
        }
        // Write your code here.
        return least.value;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }
}
