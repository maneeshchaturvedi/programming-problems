package main.java.com.dsalgo;

public class ValidateBST {

    public static boolean validateBst(BST tree) {
        return validateBSTHelper(tree,Integer.MIN_VALUE,Integer.MAX_VALUE);
        // Write your code here.

    }

    private static boolean validateBSTHelper(BST tree, int minValue, int maxValue) {
        if (tree.value > maxValue || tree.value < minValue){
            return false;
        }
        if (tree.left != null && !validateBSTHelper(tree.left,minValue,tree.value)) {
            return false;
        }
        if(tree.right!=null && !validateBSTHelper(tree.right,tree.value,maxValue)){
            return false;
        }
        return true;
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
