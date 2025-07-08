package src.Maths8;

import java.util.Arrays;

public class LC_832_17 {
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
        int right=image.length-1;

        while(row< image.length){
            int temp=image[row][left];
            image[row][left]=image[row][right];
            image[row][right]=temp;
            left++;
            right--;
            if (left>=right){
                row++;
                left=0;
                right=image.length-1;
            }
        }
        invert(image);

        return image;
    }

    static void invert(int[][] image){
        int row=0;
        int left=0;
        while(row<image.length){
            if (image[row][left]==1){
                image[row][left]=0;
            }else {
                image[row][left] = 1;
            }
            left++;
            if (left==image.length){
                row++;
                left=0;
            }
        }
    }

}
