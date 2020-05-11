package main.java.com.dsalgo;

import java.util.ArrayList;
import java.util.List;

public class RiverSizes {
    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> sizes = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visited[i][j]) {
                    continue;
                }
                visitNode(i, j, matrix, visited, sizes);
            }
        }
        return sizes;
    }

    private static void visitNode(int i, int j, int[][] matrix, boolean[][] visited, List<Integer> sizes) {
        int currentRiverSize = 0;
        List<Integer[]> nodesToVisit = new ArrayList<>();
        nodesToVisit.add(new Integer[]{i, j});
        while (!nodesToVisit.isEmpty()) {
            Integer[] nodeToExplore = nodesToVisit.get(0);
            nodesToVisit.remove(0);
            i = nodeToExplore[0];
            j = nodeToExplore[1];
            if (visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            if (matrix[i][j] == 0) {
                continue;
            }
            currentRiverSize++;
            nodesToVisit.addAll(getUnvisitedNeighbours(i, j, matrix, visited));
        }
        if (currentRiverSize > 0){
            sizes.add(currentRiverSize);
        }


    }

    private static List<Integer[]> getUnvisitedNeighbours(int i, int j, int[][] matrix, boolean[][] visited) {
        List<Integer[]> unvisitedNeighbours = new ArrayList<>();
        if (i > 0 && !visited[i - 1][j]) {
            unvisitedNeighbours.add(new Integer[]{i-1,j});
        }
        if (i<matrix.length-1  && !visited[i+1][j]){
            unvisitedNeighbours.add(new Integer[]{i+1,j});
        }
        if (j>0 && !visited[i][j-1]){
            unvisitedNeighbours.add(new Integer[]{i,j-1});
        }
        if (j<matrix[0].length-1 && !visited[i][j+1]){
            unvisitedNeighbours.add(new Integer[]{i,j+1});
        }
        return unvisitedNeighbours;
    }
}
