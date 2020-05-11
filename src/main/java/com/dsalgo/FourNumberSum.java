package main.java.com.dsalgo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourNumberSum {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {
        // Write your code here.
        Map<Integer,List<Integer[]>> allPairsSum = new HashMap<>();
        List<Integer[]> quadruplets = new ArrayList<>();

        for(int i=1;i<array.length-1;i++){
            for (int j=i+1;j<array.length;j++){
                int currentSum = array[i]+array[j];
                int difference = targetSum - currentSum;
                if (allPairsSum.containsKey(difference)){
                    for(Integer[]pair:allPairsSum.get(difference)){
                        quadruplets.add(new Integer[]{pair[0],pair[1],array[i],array[j]});
                    }
                }

            }
            for(int k=0;k<i;k++){
                int currentSum = array[i] + array[k];
                Integer[] pair = new Integer[]{array[i],array[k]};
                if(!allPairsSum.containsKey(currentSum)){
                    List<Integer[]> pairs = new ArrayList<>();
                    pairs.add(pair);
                    allPairsSum.put(currentSum,pairs);
                }else{
                    allPairsSum.get(currentSum).add(pair);
                }
            }
        }

        return quadruplets;
    }

    public static void main(String[] args) {
        int[]array= new int[]{7,6,4,1,-1,2};
        List<Integer[]> quadruplets = fourNumberSum(array,16);
        for(Integer[] quad:quadruplets){
            for(int num:quad){
                System.out.println(num);
            }
        }
    }
}
