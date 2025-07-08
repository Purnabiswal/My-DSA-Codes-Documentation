package src.Strivers.Sorting;

import java.util.Arrays;

public class LongestConsecutiveSequence_LC128 {
    public static void main(String[] args) {
        int[] arr={0,3,7,2,5,8,4,6,0,1};
        //System.out.println(longestConsecutive(arr));
        //System.out.println(longestConsecutive2(arr));
        System.out.println(longestConsecutive3(arr));
    }
    //correct
    static int longestConsecutive3(int[] arr){
        Arrays.sort(arr);
        int i=1;
        int longest=Integer.MIN_VALUE;
        int count=1;
        int lastSmaller=Integer.MIN_VALUE;
        while(i<arr.length){
            lastSmaller=arr[i-1];
            if((arr[i]-1)==lastSmaller){
                count++;
            }else if(arr[i] != lastSmaller && (arr[i]-1) != lastSmaller){
                if (count>longest){
                    longest=count;
                }
                count=1;
            }
            i++;
        }
        longest=Integer.max(longest,count);
        return longest;
    }
    //wrong
    static public int longestConsecutive(int[] arr) {
        int counter=0;
        int min=Integer.MAX_VALUE;
        for (int element : arr) {
            if (element < min && element>=0) {
                min = element;
            }
        }
        int i=0;

        while(i<arr.length){
            int correctIdx=arr[i]-min;
            if(i!=correctIdx && correctIdx<arr.length && correctIdx>=0 && arr[i] !=arr[correctIdx]){
                int temp=arr[correctIdx];
                arr[correctIdx]=arr[i];
                arr[i]=temp;
            }else{
                i++;
            }
        }

        int answer=0;
        for(i=0;i<arr.length;i++){
            int correctIdx=arr[i]-min;
            if(i==correctIdx){
                counter++;
                answer=counter;
            }
            if (i != correctIdx){
                counter=0;
            }
        }

        return answer;
    }

    static public int longestConsecutive2(int[] arr) {
        Arrays.sort(arr);
        int i=0;
        int count=1;
        int ans=1;
        while(i<arr.length){
            boolean isConsecutive=(i+1< arr.length && (arr[i] == arr[i+1] || arr[i]+1 == arr[i+1]));
            if(isConsecutive){
                count++;
                ans=count;
            }else{
                count=1;
            }
            i++;
        }
        return ans;
    }


}
