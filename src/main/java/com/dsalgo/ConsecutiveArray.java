package main.java.com.dsalgo;

import java.util.HashMap;

public class ConsecutiveArray {

    public static int consecutiveArray(int[]array){
        HashMap<Integer,Boolean> values = new HashMap<>();
        for(int value:array){
            values.put(value,false);
        }
        int maxLength = 0;
        for(int val:array) {
            int length=0;
            boolean visited =values.get(val);
            if (!visited){
                values.replace(val,true);
                length++;
                int decrement = val-1;
                while(values.containsKey(decrement)){
                    values.replace(decrement,true);
                    length++;
                    decrement--;
                }
                int increment = val+1;
                while(values.containsKey(increment)){
                    values.replace(increment,true);
                    length++;
                    increment++;
                }
            }
            if (length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[]array = new int[]{4,1,2,0,-1,5,6};
        System.out.println(consecutiveArray(array));
    }
}
