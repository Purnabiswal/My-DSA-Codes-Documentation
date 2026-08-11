package src.T_21_Greedy;

import java.util.Arrays;

public class GD2_LC_860_LemonadeChange {
    public static void main(String[] args) {
        int[] bills={5,5,10,20,5,5,5,5,5,5,5,5,5,10,5,5,20,5,20,5};
        System.out.println(lemonadeChange(bills));
    }

    static public boolean lemonadeChange(int[] bills) {
        int[] change={0, 0}; //{10s, 5s}

        for(int i=0;i<bills.length;i++){
            int g=bills[i]-5;
            for(int j=0;j<change.length;j++){
                if(g==0) break;
                if(g>=10 && change[0]>0){
                    change[0]--;
                    g-=10;
                }else if(g>=5 && change[1]>0){
                    while(change[1]>0 && g>0) {
                        change[1]--;
                        g-=5;
                    }
                }else{
                    break;
                }
            }
            if(g!=0) return false;

            if(bills[i]==10){
                change[0]++;
            }else if(bills[i]==5){
                change[1]++;
            }
        }
        return true;
    }



}
