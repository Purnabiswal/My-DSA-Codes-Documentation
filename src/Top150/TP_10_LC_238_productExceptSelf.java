package src.Top150;

public class TP_10_LC_238_productExceptSelf {
    public static void main(String[] args) {

    }

    //Way1
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] ans=new int[n];
        int x=1;
        int zeroCount=0;
        int zeroIdx=0;
        for (int i = 0; i < n; i++) {
            if (nums[i]==0) {
                zeroCount++;
                if (zeroCount==1){
                    zeroIdx=i;
                    continue;
                }
            }
            x*=nums[i];
        }
        if (zeroCount>1) return ans;
        if (zeroCount==1){
            ans[zeroIdx]=x;
            return ans;
        }

        for (int i = 0; i < n; i++) {
            ans[i]=divide(x, nums[i]);
        }

        return ans;
    }

    int divide(int x, int y){
        return (int) (x*Math.pow(y, -1));
    }


    //Way-2: Using prefix suffix
    public int[] productExceptSelf2(int[] nums) {
        int n= nums.length;
        int[] ans=new int[n];
        int prefix=1;
        for (int i = 0; i < n; i++) {
            ans[i]=prefix;
            prefix=prefix*nums[i];
        }

        int suffix=1;
        for (int i = n-1; i >= 0; i--) {
            ans[i]*=suffix;
            suffix=suffix*nums[i];
        }

        return ans;
    }
}
