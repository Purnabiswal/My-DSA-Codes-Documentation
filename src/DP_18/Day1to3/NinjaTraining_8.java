package src.DP_18.Day1to3;

import java.util.Arrays;

//Ninja’s Training
public class NinjaTraining_8 {
    public static void main(String[] args) {
        int[][] points={{11,26,4}, {3 ,7 ,1} ,{3,9,34}};
        System.out.println(ninjaTraining(points.length, points));
        System.out.println(ninjaTraining2(points.length, points));
        System.out.println(ninjaTraining3(points.length, points));

    }


    //Memoization:
    //TC: O(N*4*3)
    //SC: O(N)+O(N*4)
    public static int ninjaTraining(int n, int[][] points) {
        int[][] dp=new int[n][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return ninjaTraining(n-1, points, 3, dp);
    }
    public static int ninjaTraining(int day, int[][] points, int last, int[][] dp) {
        if (day==0){
            int max=Integer.MIN_VALUE;
            for (int task = 0; task < 3; task++) {
                if (task!=last){
                    max=Math.max(max, points[day][task]);
                }
            }
            return max;
        }

        if (dp[day][last]!=-1){
            return dp[day][last];
        }

        int maxPoints=Integer.MIN_VALUE;
        for (int task = 0; task < 3; task++) {
            //skip current i in next call
            if (task!=last){
                int call=points[day][task]+ninjaTraining(day-1, points, task, dp);
                maxPoints=Math.max(maxPoints, call);
            }
        }
        dp[day][last]=maxPoints;
        return maxPoints;
    }


    //Tabulation:
    //TC: O(N*4*3)
    //SC: O(N*4)
    public static int ninjaTraining2(int n, int[][] points) {
        int[][] dp=new int[n][4];
        int maxPoints=Integer.MIN_VALUE;
        //for '0' index
        for (int last = 0; last < 4; last++) {
            maxPoints=Integer.MIN_VALUE;
            for (int task = 0; task < 3; task++) {
                if (task!=last){
                    maxPoints=Math.max(maxPoints, points[0][task]);
                }
            }
            dp[0][last] = maxPoints;
        }
        //indices
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                maxPoints=Integer.MIN_VALUE;
                for (int task = 0; task < 3; task++) {
                    if (task!=last){
                        //skip current j in next iteration
                        int call=points[day][task]+dp[day-1][task];
                        maxPoints=Math.max(maxPoints, call);
                    }
                }
                dp[day][last]=maxPoints;
            }
        }
        return maxPoints;
    }

    //Tabulation:
    //Space optimized
    //TC: O(N*4*3)
    //SC: O(4)
    public static int ninjaTraining3(int n, int[][] points) {
        int[] prev=new int[4];

        //for '0' index
        for (int last = 0; last < 4; last++) {
            int maxPoints=Integer.MIN_VALUE;
            for (int task = 0; task < 3; task++) {
                if (task!=last){
                    maxPoints=Math.max(maxPoints, points[0][task]);
                }
            }
            prev[last] = maxPoints;
        }
        //indices
        for (int day = 1; day < n; day++) {
            int[] temp=new int[4];
            for (int last = 0; last < 4; last++) {
                int maxPoints=Integer.MIN_VALUE;
                //previous day tasks loop below
                for (int task = 0; task < 3; task++) {
                    if (task!=last){
                        //skip current j in next iteration
                        int point=points[day][task]+prev[task];
                        maxPoints=Math.max(maxPoints, point);
                    }
                }
                temp[last]=maxPoints;
            }
            prev=temp;
        }
        return prev[3];
    }

}
