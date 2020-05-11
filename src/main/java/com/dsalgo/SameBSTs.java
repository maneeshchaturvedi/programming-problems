package main.java.com.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTs {

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {
        // Write your code here.
        if(arrayOne.size()!=arrayTwo.size()){
            return false;
        }
        if (arrayOne.size()==0 && arrayTwo.size()==0){
            return true;
        }
        if (arrayOne.get(0) != arrayTwo.get(0)){
            return false;
        }
        List<Integer>leftOne = getSmaller(arrayOne);
        List<Integer>leftTwo = getSmaller(arrayTwo);
        List<Integer>rightOne = getBiggerOrEqual(arrayOne);
        List<Integer>rightTwo = getBiggerOrEqual(arrayTwo);

        return sameBsts(leftOne,leftTwo) && sameBsts(rightOne,rightTwo);
    }

    public static List<Integer> getSmaller(List<Integer>array){
        List<Integer>smaller = new ArrayList<>();
        for(int i=1;i<array.size();i++){
            if(array.get(i) < array.get(0)){
                smaller.add(array.get(i));
            }
        }
        return smaller;
    }

    public static List<Integer> getBiggerOrEqual(List<Integer>array){
        List<Integer>bigger = new ArrayList<>();
        for(int i=1;i<array.size();i++){
            if(array.get(i) >= array.get(0)){
                bigger.add(array.get(i));
            }
        }
        return bigger;
    }

    public static void main(String[] args) {
        List<Integer> arrayOne =
                new ArrayList<Integer>(Arrays.asList(50, 76, 81, 23, 23, 23, 657, 56, 12, -1, 3));
        List<Integer> arrayTwo =
                new ArrayList<Integer>(Arrays.asList(50, 23, 76, 23, 23, 12, 56, 81, -1, 3, 657));
        System.out.println(sameBsts(arrayOne,arrayTwo));
    }
}
