package src.T_22_Contest;

import java.util.Arrays;

//Links are in order of Q1...
//https://leetcode.com/contest/weekly-contest-513/problems/maximize-pair-strength-using-gcd/description/
//https://leetcode.com/contest/weekly-contest-513/problems/count-subarrays-with-even-odd-ratio-i/
//https://leetcode.com/contest/weekly-contest-513/problems/count-of-unfinished-tasks-after-each-shift/
public class C513_ {
    public static void main(String[] args) {
        int[] tasks  = {3, 5, 2, 7, 4};
        int[] shifts = {2, 1, 10, 4, 8, 20, 3, 5};

        System.out.println(Arrays.toString(countTasks(tasks, shifts)));

    }




    //q3
    static public int[] countTasks(int[] tasks, int[] shifts) {
        //ans = [5, 4, 2, 1, 0, 1, 0, 4]
        int n=tasks.length;
        int m=shifts.length;
        int[] psum=new int[n];
        int[] ans=new int[m];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=tasks[i];
            psum[i]=sum;
        }

        int ssum=0;
        for(int i=0;i<m;i++){
            ssum+=shifts[i];

            ans[i]=n-(bs(psum, ssum)+1); //index+1 is completed tasks


            if(ssum>=sum) ssum=0;
        }

        return ans;
    }

    static int bs(int[] psum, int t){
        int m;
        int s=0;
        int e=psum.length-1;
        while(s<=e){
            m=s+(e-s)/2;
            if(t<psum[m]){
                e=m-1;
            }else if(t>psum[m]){
                s=m+1;
            }else{
                return m;
            }
        }
        return e;
    }





    //q2
    public int countRatioSubarrays(int[] nums, int a, int b) {

        int ans=0;

        for(int i=0;i<nums.length;i++){
            int evens=0;
            int odds=0;

            for(int j=i;j<nums.length;j++){
                if(nums[j]%2!=0){
                    odds++;
                } else{
                    evens++;
                }
                if(odds==0) continue;
                if(evens*b<=odds*a){
                    ans++;
                }
            }
        }

        return ans;
    }

    //Q1
    public long maxPairStrength(int[] nums) {
        long m=Integer.MIN_VALUE;


        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                long g=gcd(nums[i], nums[j]);
                m=Math.max(m, (1L*nums[i] * nums[j])/(g*g));
            }
        }

        return m;
    }


    long gcd(long n1, long n2){


        while(n1%n2!=0){
            long rem=n1%n2;
            n1=n2;
            n2=rem;
        }

        return n2;
    }


}
