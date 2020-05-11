package main.java.com.dsalgo;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStack {
    List<Integer> stack = new ArrayList<>();
    List<Integer[]> minMaxStack = new ArrayList<Integer[]>();
    Integer currentMin = Integer.MAX_VALUE;
    Integer currentMax = Integer.MIN_VALUE;

    public int peek() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.get(stack.size() - 1);

    }

    public int pop() {
        if (stack.isEmpty()) {
            return -1;
        }
        int result = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        minMaxStack.remove(minMaxStack.size() - 1);
        if (minMaxStack.size() ==0 ){
            currentMax = Integer.MIN_VALUE;
            currentMin = Integer.MAX_VALUE;
        }else if (minMaxStack.size() > 0){
            currentMin = minMaxStack.get(minMaxStack.size()-1)[0];
            currentMax = minMaxStack.get(minMaxStack.size()-1)[1];
        }

        return result;
    }

    public void push(Integer number) {
        stack.add(number);
        if (number < currentMin) {
            currentMin = number;
        }
        if (number > currentMax) {
            currentMax = number;
        }
        minMaxStack.add(new Integer[]{currentMin, currentMax});

    }

    public int getMin() {
        // Write your code here.
        return minMaxStack.get(minMaxStack.size() - 1)[0];
    }

    public int getMax() {
        // Write your code here.
        return minMaxStack.get(minMaxStack.size() - 1)[1];
    }


    public static boolean balancedBrackets(String str) {
        // Write your code here.
        int result =0;
        char[] chars = str.toCharArray();
        for(char c:chars){
            if (c=='(' || c=='{'||c=='['){
                result++;
            }else if (c=='}' || c==')'||c==']'){
                result--;
            }
        }
        return result == 0;
    }
    public static void main(String[] args) {
        System.out.println(balancedBrackets("{[[[[({(}))]]]]}"));
        MinMaxStack stack = new MinMaxStack();
        stack.push(2);
        assert stack.getMin() ==2;
        assert stack.getMax() ==2;
        assert stack.peek() ==2;
        stack.push(0);
        assert stack.getMin() ==0;
        assert stack.getMax() ==2;
        assert stack.peek() ==0;
        stack.push(5);
        assert stack.getMin() ==0;
        assert stack.getMax() ==5;
        assert stack.peek() ==5;


    }
}

