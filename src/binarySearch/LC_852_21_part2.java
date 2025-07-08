package src.binarySearch;

//https://leetcode.com/problems/find-peak-element/description/
public class LC_852_21_part2 {
    public static void main(String[] args) {
        int[] arr={3,5,3,2,0};
        System.out.println(peakIndexInMountainArray(arr));
    }

    static int peakIndexInMountainArray(int[] arr) {
        int s=0;
        int e=arr.length-1;

        while(s<e){
            int m=s+(e-s)/2;
            if(arr[m]<arr[m+1]){
                //You are in the increasing part of the array
                s=m+1;  //because we know that m+1 element > mid element
            }else { //arr[m] > arr[mid+1]
                //you are in the decreasing part of the array
                //this may be the answer, but look at left
                //this is why e != mid-1, timestamp: binary search interview ques ,2:14:30 of 4:01:46
                e=m;
            }
        }
        //In the end, s==e and pointing to the largest number because of the 2 checks above
        //s and e aare always trying to find max element in the above 2 checks
        //hence, when they are pointing to just one element, that is the max one because that is what the checks say
        //More elaboration: at every point of time for start and end, they have the best possible answer till that time
        // and if we are saying that only one item is remaining, hence cuz of above line that is the best possible answer
        return s; //or e , because both are equal.
    }
}
