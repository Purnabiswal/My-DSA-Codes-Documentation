package src.Top150;

import java.util.Collections;
import java.util.Stack;

public class TP_12_LC_42_Trapping_Rain_Water {
    public static void main(String[] args) {
        TP_12_LC_42_Trapping_Rain_Water ob=new TP_12_LC_42_Trapping_Rain_Water();


//        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        int[] height={4,2,0,3,2,5};
//        int[] height={4,2,3};

        System.out.println(ob.trap(height));
        System.out.println(ob.trap1(height));
        System.out.println(ob.trap2(height));
    }


    //Way-3
    //Efficient
    public int trap2(int[] height) {
        int trap_water=0;
        int n= height.length;
        int prevG=height[0];
        int nextGIdx=-1;
        Stack<Integer> stack=new Stack<>();
        stack.push(n-1);
        for (int j = n-1; j >= 0; j--) {
            if (height[stack.peek()]<height[j]){
                stack.push(j);
            }
        }
        for (int i = 0; i < n; i++) {
            if (height[i]>prevG) prevG=height[i];
            if (i>nextGIdx){
                nextGIdx=stack.pop();
            }
            trap_water+=Math.min(prevG, height[nextGIdx])-height[i];
        }
        return trap_water;
    }





    //Efficient
    public int trap(int[] height) {

        int trap_water=0;
        int i=0;
        int n= height.length;
        int prevG=height[0];
        int nextGIdx=-1;
        while (i<n){
            if (height[i]>prevG) prevG=height[i];
            if (i>nextGIdx){
                nextGIdx=nextG(i, height);
            }
            trap_water+=Math.min(prevG, height[nextGIdx])-height[i];

            i++;
        }


        return trap_water;
    }
    public int nextG(int n, int[] height){
        int maxi = n;
        for(int i=n+1;i<height.length;i++){
            if(height[i]> height[maxi]){
                maxi = i;
            }
        }
        return maxi;
    }

    //Bruteforce
    public int trap1(int[] height) {
        int trap_water=0;
        int i=0;
        int n= height.length;
        while (i<n){
            int pg=prevG1(i,height);
            int ng=nextG1(i, height);
            if (pg!=-1 && ng!=-1){
                trap_water+=Math.min(pg, ng)-height[i];
            }

            i++;
        }
        return trap_water;
    }
    public int nextG1(int n, int[] height){
        int max=height[n];
        for(int i=n+1;i<height.length;i++){
            if(height[i]>max){
                max=height[i];
            }
        }
        return max;
    }
    public int prevG1(int n, int[] height){
        int max=height[n];
        for(int i=n-1;i>=0;i--){
            if(height[i]>max){
                max=height[i];
            }
        }
        return max;
    }



}
