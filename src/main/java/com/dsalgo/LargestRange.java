package main.java.com.dsalgo;

import java.util.HashMap;
import java.util.Map;

public class LargestRange {
    public static int[] largestRange(int[] array) {
        // Write your code here.

        if(array.length==0){
            return new int[]{array[0],array[0]};
        }
        Map<Integer, Boolean> values = new HashMap<>();
        int start = 0;
        int end = 0;
        int longest = 0;
        int[]result = new int[2];
        for (int num : array) {
            values.put(num, false);
        }

        for (int num : array) {
            if(!values.get(num)){
                int prev = num;
                while (values.containsKey(prev)) {
                    start = prev;
                    values.replace(prev, true);
                    prev = prev - 1;

                }
                int next = num;
                while (values.containsKey(next)) {
                    end = next;
                    values.replace(next, true);
                    next = next + 1;

                }
                int currentLength = end - start;
                if (currentLength > longest){
                    longest = currentLength;
                    result[0] = start;
                    result[1] = end;
                }
            }


        }
        return result;
    }
}
