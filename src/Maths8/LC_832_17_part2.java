package src.Maths8;

import java.util.Arrays;

public class LC_832_17_part2 {
    public static void main(String[] args) {
        int[][] image = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};


        flipAndInvertImage(image);


        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(image[i]));
        }

    }

    static int[][] flipAndInvertImage(int[][] image){
        int row=0;
        int left=0;
        int right=image[0].length-1;

        while(row< image.length){
            // swap and invert at a time
            int temp=image[row][left]^1;
            image[row][left]=image[row][right]^1;
            image[row][right]=temp;
            left++;
            right--;
            if (left>right){
                row++;
                left=0;
                right=image.length-1;
            }
        }
        return image;
    }
}
