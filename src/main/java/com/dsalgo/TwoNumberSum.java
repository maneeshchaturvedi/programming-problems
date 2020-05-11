package main.java.com.dsalgo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoNumberSum {

    public static int[] twoNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        int startIdx = 0;
        int endIdx = array.length - 1;
        while (startIdx < endIdx) {
            if (array[startIdx] + array[endIdx] == targetSum) {
                return new int[]{array[startIdx], array[endIdx]};
            } else if (array[startIdx] + array[endIdx] < targetSum) {
                startIdx++;
            } else if (array[startIdx] + array[endIdx] > targetSum) {
                endIdx--;
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSumV2(int[] array, int targetSum) {
        Map<Integer, Boolean> nums = new HashMap<>();
        for (int num : array) {
            int target = targetSum - num;
            if (nums.containsKey(target)) {
                return new int[]{target, num};
            } else {
                nums.put(num, true);
            }
        }
        return new int[0];
    }


    public static void main(String[] args) {
        int[] array = new int[]{3, 5, -4, 8, 11, 1, -1, 6};
        int[] res = twoNumberSum(array, 10);
        int[] res1 = twoNumberSumV2(array, 10);
        System.out.println(res[0] + "," + res[1]);
        System.out.println(res1[0] + "," + res1[1]);
    }
}
