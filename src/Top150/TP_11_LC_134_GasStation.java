package src.Top150;

public class TP_11_LC_134_GasStation {
    public static void main(String[] args) {

        int[] gas = {4,5,2,6,5,3};
        int[] cost = {3,2,7,3,2,9};
        //{-2, -2, -2, 3, 3}
        //{0, 1, 2, 7, 4}

        System.out.println(canCompleteCircuit(gas, cost));
    }

    //wrong output
    static public int canCompleteCircuit(int[] gas, int[] cost) {
        int n= gas.length;

        for (int i = 0; i < n; i++) {
            int tank=gas[i];
            int c=cost[i];
            if (tank-c<0) continue;
            tank=tank-c+gas[(i+1)%n];
            int j=0;
            for (j = (i+1)%n; j != i; j=(j+1)%n) {
                c=cost[j];
                if (tank-c<0) break;
                tank=tank-c+gas[(j+1)%n];
            }
            if (j==i) return i;
        }

        return -1;
    }



}
