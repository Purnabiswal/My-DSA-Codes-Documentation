package src.Recursion10.Recursion1;

//Binary search using recursion
public class BinarySearch2ndWay6 {
    public static void main(String[] args) {

        int[] arr={-18,-12,-4,0,2,3,4,15,16,18,22,45,89};
        int target=45;
        System.out.println(search(arr,target,0,arr.length-1));
    }

    //Good way:
    static int search(int[] arr,int target,int s,int e){
        int m=s+(e-s)/2;
        //base condition
        if (arr[m]==target){
            return m;
        }
        if (s>e){
            return -1;
        }
        //body
        if (arr[m]<target){
            return search(arr,target,m+1,e);
        }
        return search(arr,target,s,m-1);//This will execute only if when above "If" statement is false
    }
}
