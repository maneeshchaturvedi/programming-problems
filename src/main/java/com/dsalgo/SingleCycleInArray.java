package main.java.com.dsalgo;

public class SingleCycleInArray {

    public static boolean hasSingleCycle(int[] array) {
        int []visited = new int[array.length];
        int startIdx = 0;
        int nextIdxToVisit = 0;
        int numElementsVisited = 0;
        int length = array.length;
        while(true){
            if(numElementsVisited == length && nextIdxToVisit==startIdx){
                return true;
            }
            numElementsVisited++;
            visited[nextIdxToVisit]+=1;
            if(visited[nextIdxToVisit]>1){
                return false;
            }

            nextIdxToVisit = nextIdxToVisit + array[nextIdxToVisit];
            while(nextIdxToVisit < 0 ){
                nextIdxToVisit = (length + nextIdxToVisit)%length;
            }
            while (nextIdxToVisit >= length){
                nextIdxToVisit = (nextIdxToVisit - length)%length;
            }

        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{10,11,-6,-23,-2,3,88,908,-26};
        System.out.println(hasSingleCycle(array));
    }
}
