package main.java.com.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZigZagTraversal {
    public static List<Integer> zigzagTraverse(int[][] array) {
        // Write your code here.
        int height = array.length-1;
        int width = array[0].length-1;
        int row = 0;
        int col = 0;
        boolean goingDown = true;
        List<Integer> result = new ArrayList<>();
        while (!outOfBounds(row, col, height, width)) {
            result.add(array[row][col]);
            if (goingDown) {
                if (col == 0 || row == height) {
                    goingDown = false;
                    if (row == height) {
                        col++;
                    } else {
                        row++;
                    }
                } else {
                    row++;
                    col--;
                }


            } else {
                if (row == 0 || col == width){
                    goingDown = true;
                    if (col==width){
                        row++;
                    }else{
                        col++;
                    }
                }else{
                    row--;
                    col++;
                }
            }

        }
        return result;
    }

    public static boolean outOfBounds(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 || col > width;
    }

    public static void main(String[] args) {
        int[][]arr = new int[][]{{1,3,4,10},{2,5,9,11},{6,8,11,15},{7,13,14,16}};
        for(int num:zigzagTraverse(arr)){
            System.out.println(num);
        }
    }
}
