package main.java.com.dsalgo;

import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.javac.jvm.ByteCodes.swap;

public class Permutations {
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Write your code here.
        List<List<Integer>> permutations = new ArrayList<>();
        helper(array,new ArrayList<Integer>(),permutations);
        return permutations;
    }

    private static void helper(List<Integer> array, List<Integer> currentPermutaion, List<List<Integer>> permutations) {
        if (array.isEmpty() && !currentPermutaion.isEmpty()){
            permutations.add(currentPermutaion);
        }else{
            for(int i=0;i<array.size();i++){
                List<Integer>newArray = new ArrayList<>(array);
                newArray.remove(array.get(i));
                List<Integer>newPermutation = new ArrayList<>(currentPermutaion);
                newPermutation.add(array.get(i));
                helper(newArray,newPermutation,permutations);
            }
        }
    }

    private static void helper1(int i, List<Integer> array ,List<List<Integer>> permutations) {
        if (i==array.size()-1){
            permutations.add(new ArrayList<>(array));
        }else{
            for(int j=i;j<array.size();j++){
                swap(i,j,array);
                helper1(i+1,array,permutations);
                swap(i,j,array);
            }
        }
    }

    private static void swap(int i, int j, List<Integer> array) {
        Integer temp = array.get(i);
        array.set(i,array.get(j));
        array.set(j,temp);

    }
}
