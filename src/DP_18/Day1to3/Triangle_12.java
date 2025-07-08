package src.DP_18.Day1to3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_12 {
    public static void main(String[] args) {

        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(triangle); // optional: to print and check

        System.out.println(minimumTotal(triangle));
        System.out.println(minimumTotal2(triangle));
        System.out.println(minimumTotal3(triangle));
        System.out.println(minimumTotal4(triangle));
    }


    //Recursion
    //TC: O(2^(N*N))
    //SC: O(N)
    static public int minimumTotal(List<List<Integer>> triangle) {


        return f(0, 0, triangle);
    }

    static public int f(int i, int j, List<List<Integer>> triangle) {
        if (i == triangle.size() - 1) {
            return triangle.get(i).get(j);
        }

        int down = f(i + 1, j, triangle);
        int dia = f(i + 1, j + 1, triangle);

        return Math.min(down, dia) + triangle.get(i).get(j);
    }


    //Memoization
    //TC: O(N*N)
    //SC: O(N) + O(N*N)
    static public int minimumTotal2(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];
        for (int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return f2(0, 0, triangle, dp);
    }

    static public int f2(int i, int j, List<List<Integer>> triangle, int[][] dp) {
        int cur = triangle.get(i).get(j);
        if (i == triangle.size() - 1) {
            return cur;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = f2(i + 1, j, triangle, dp);
        int dia = f2(i + 1, j + 1, triangle, dp);

        return dp[i][j] = Math.min(down, dia) + cur;
    }

    //Tabulation
    //TC: O(N*N)
    //SC: O(N*N)
    static public int minimumTotal3(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[][] dp = new int[size][size];

        //base case
        for (int i = 0; i < size; i++) {
            dp[size-1][i] = triangle.get(size-1).get(i);
        }

        for (int i = size-2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                int down = dp[i+1][j];
                int dia = dp[i+1][j+1];

                dp[i][j] = Math.min(down, dia) + triangle.get(i).get(j);
            }
        }

        return dp[0][0];
    }

    //Tabulation
    //TC: O(N*N)
    //SC: O(N)
    static public int minimumTotal4(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];

        //base case
        for (int i = 0; i < size; i++) {
            dp[i] = triangle.get(size-1).get(i);
        }

        for (int i = size-2; i >= 0; i--) {
            int[] cur = new int[size];
            for (int j = 0; j <= i; j++) {
                int down = dp[j];
                int dia = dp[j+1];

                cur[j] = Math.min(down, dia) + triangle.get(i).get(j);
            }
            dp = cur;
        }

        return dp[0];
    }

}
