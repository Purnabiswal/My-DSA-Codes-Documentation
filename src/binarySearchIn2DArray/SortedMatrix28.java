package src.binarySearchIn2DArray;

//Whole matrix is sorted
//The previous code for "SortedMatrix28" also work for this
//But the below code has less TC

import java.util.Arrays;

public class SortedMatrix28 {
    public static void main(String[] args) {
//        int[][] arr={
//                {1,2,3,4},
//                {5,6,7,8},
//                {9,10,11,12},
//                {13,14,15,16}
//        };

//        int[][] arr={{1}};

        int[][] arr={
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,50}
        };

        int target=7;
        System.out.println(Arrays.toString(search(arr,target)));
    }

    static int[] search(int[][] matrix, int target){
        int rSta=0;
        int rEnd=matrix.length-1;
        int cSta=0;
        int cEnd=matrix[rSta].length-1;

        if(matrix.length==1){
            return binarySearch(matrix[0],0,0,cEnd,target);
        }


        while(true){
            int rMid=rSta+(rEnd-rSta)/2;
            int cMid=cSta+(cEnd-cSta)/2; //column mid is not changing through entire the program, so it can be written outside the loop
            if (target==matrix[rMid][cMid]){
                return new int[]{rMid,cMid};
            }else if(rSta+1==rEnd){  //now we have 2 rows
                //check whether the target is in the column of 2 rows
                if (matrix[rSta][cMid]==target){
                    return new int[]{rSta,cMid};
                }else if(matrix[rEnd][cMid]==target){
                    return new int[]{rEnd,cMid};
                }
                //otherwise
                else {
                    //search in 1st half
                    if(target<matrix[rSta][cMid]){
                        return binarySearch(matrix[rSta],rSta,cSta,cMid-1,target);
                    }
                    //search in 2nd half
                    else if(target>matrix[rSta][cMid] && target<=matrix[rSta][cEnd]){
                        return binarySearch(matrix[rSta],rSta,cMid+1,cEnd,target);
                    }
                    //search in 3rd half
                    else if(target<matrix[rEnd][cMid]){
                        return binarySearch(matrix[rEnd],rEnd,cSta,cMid-1,target);
                    }
                    //search in 3rd half
                    else{
                        return binarySearch(matrix[rEnd],rEnd,cMid+1,cEnd,target);
                    }
                }
            }
            else if(target<matrix[rMid][cMid]){
                rEnd=rMid;
            }else if(target>matrix[rMid][cMid]){
                rSta=rMid;
            }


        }
    }

    //search in the row provided between the columns provided
    static int[] binarySearch(int[] matrix,int row,int cSta,int cEnd,int target){
        while (cSta<=cEnd){
            int m=cSta+(cEnd-cSta)/2;
            if(target==matrix[m]){
                return new int[]{row,m};
            }else if(target<matrix[m]){
                cEnd=m-1;
            }else {
                cSta=m+1;
            }
        }
        return new int[]{-1,-1};
    }
}
