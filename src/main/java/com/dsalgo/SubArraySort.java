package main.java.com.dsalgo;

import java.util.Map;

public class SubArraySort {
    public static int[] subarraySort(int[] array) {
        int minUnsorted = Integer.MAX_VALUE;
        int maxUnsorted = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int num = array[i];
            if (isOutOfOrder(i, num, array)) {
                minUnsorted = Math.min(num, minUnsorted);
                maxUnsorted = Math.max(num, maxUnsorted);
            }
        }
        if (minUnsorted == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        int startIndex = 0;
        while (minUnsorted > array[startIndex]) {
            startIndex++;
        }

        int endIndex = array.length - 1;
        while (maxUnsorted < array[endIndex]) {
            endIndex--;
        }
        return new int[]{startIndex, endIndex};
    }


    private static boolean isOutOfOrder(int i, int num, int[] array) {
        if (i == 0) {
            return num > array[i + 1];
        }
        if (i == array.length - 1) {
            return num < array[i - 1];
        }
        return num < array[i - 1] || num > array[i + 1];
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        subarraySort(array);
    }

}
