package main.java.com.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PowerPuff {

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);

//        int firstInput = scanner.nextInt();
//        String secondInput = scanner.nextLine();
//        String thirdInput = scanner.nextLine();
//        long numIngreidients = Long.parseLong(firstInput);
//        long[] requiredQuantities = Arrays.stream(secondInput.split(" ")).mapToLong(Long::parseLong).toArray();
//        long[] totalQuantities = Arrays.stream(thirdInput.split(" ")).mapToLong(Long::parseLong).toArray();
//        long currentMin = Long.MAX_VALUE;
//        for(int i=0;i<numIngreidients;i++){
//            long totalForQuantity = totalQuantities[i]/requiredQuantities[i];
//            if (totalForQuantity < currentMin){
//                currentMin = totalForQuantity;
//            }
//        }
//        System.out.println(currentMin);
        String [] words = new String[]{"is","valid","hello"};
        List<String> ws = Arrays.asList(words);
        String s = "IsValidHello";
        int start = 0;
        for(int i=1;i<s.length();i++) {
            if(Character.isUpperCase(s.charAt(i))){
                String res = s.substring(start,i);
                System.out.println(res);
                if (!ws.contains(res)){
                    System.out.println(false);
                }
                start = i;
            }

        }
        String res = s.substring(start,s.length());
        System.out.println(res);
        if (!ws.contains(res)){
            System.out.println(false);
        }
        System.out.println(true);
    }
}
