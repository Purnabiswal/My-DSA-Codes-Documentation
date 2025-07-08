package src.Patterns;


public class Patterns40 {
    public static void main(String[] args) {
        //Steps:
        //1. Run the outer for loop, the number of time you are having the lines = no. of rows
        //2. Identify for every row no., how many columns are there or types of elements in the column
        //3. What do you need to print

        //pattern1(5);
        //pattern2(4);
        //pattern3(5);
        //pattern3way2(5);
        //pattern4(5);
        //pattern5(5);
        //pattern6(5);
        //pattern7(5);
        //pattern8(5);
        //pattern9(5);
        //pattern10(5);
        //pattern11(5);
        //pattern12(5);
        //pattern13(5);
        //pattern14(5);
        //pattern15(5);
        //pattern17(4);
        //pattern28(5);
        //pattern30(5);
        pattern31(4);



    }
    
    static void pattern4(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for (int i = 1; i <= 2*n-1; i++) {
            int c=(i>n)?2*n-i:i;
            for (int j = 1; j <= c; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern6(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <=n; j++) {
                if (j>=n-i){
                    System.out.print("* ");
                }else {
                    System.out.print("  "); //use double space, otherwise it will collide with "*" space
                }
            }
            System.out.println();
        }
    }

    static void pattern7(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j>=i){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }


    static void pattern8(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 2*n; j++) {
                if (j >= n-i && j <= n+i){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void pattern9(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < 2*n; j++) {
                if (j >= i && j <= 2*n-i){
                    System.out.print("* ");
                }else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    static void pattern10(int n){
        for (int i = 1; i <= n; i++) {
            //For spaces
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }
            //For stars
            for (int k = 1; k <= i; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern11(int n){
        for (int i=0;i<n;i++){
            //For Spaces
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            //For Stars
            for (int j = 1; j <= n-i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern12(int n){
        for (int i=0;i<2*n-1;i++){

            int c=(i<n)?i:2*n-i-2;
            int d=(i<n)?n-i:i-3;
            //For Spaces
            for (int j = 1; j <= c; j++) {
                System.out.print(" ");
            }
            //For Stars
            for (int j = 1; j <= d; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern13(int n){
        for (int i = 1; i <= n; i++) {
            //Left Spaces
            for (int j = 1; j <= n-i; j++) {
                System.out.print(" ");
            }

            //Stars
            for (int k = 1; k < 2*n; k++) {
                if (k==1 || k==(i*2)-1 || i==n){
                    System.out.print("*");
                }
                //Right Spaces
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }

    static void pattern14(int n){
        for (int i = 0; i < n; i++) {
            //left spaces
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }

            //stars and right spaces
            //for (int k = 1; k < 2*n; k++) {
            for (int k = 1; k <= (n-i)*2-1; k++) {  //reduced checks
                //Stars
                if (i==0 || k==1 || k==(n-i)*2-1){
                    System.out.print("*");
                }
                //right spaces
                else {
                    System.out.print(" ");
                }
            }
            //next line after a column
            System.out.println();
        }
    }

    static void pattern15(int n){
        for (int i = 1; i < 2*n; i++) {
            //left spaces
            int s=(i<=n)?n-i:i-n;
            for (int j = 1; j <= s; j++) {
                System.out.print(" ");
            }

            int c=(i<=n)?(i*2-1):(2*n-i)*2-1;
            //stars and right spaces
            //for (int k = 1; k < 2*n; k++) {
            for (int k = 1; k <= c; k++) {  //reduced checks
                //Stars
                if (k==1 || k==c){
                    System.out.print("*");
                }
                //right spaces
                else {
                    System.out.print(" ");
                }
            }
            //next line after a column
            System.out.println();
        }
    }

    static void pattern17(int n){
        for (int i = 1; i < 2*n; i++) {
            int totalColsInRow=(i<=n)?i:2*n-i;
            //left spaces
            for (int j = 1; j <= n-totalColsInRow; j++) {
                System.out.print("  "); //Why double space here: If you give space for rest numbers or stars,
            }                           //then you also need give extra space here


            //Printing numbers till 1
            for (int j = totalColsInRow; j >= 1; j--) {
                System.out.print(j+" ");
            }
            //Printing numbers after 1
            for (int j = 2; j <= totalColsInRow; j++) {
                System.out.print(j+" ");
            }
            System.out.println();

        }
    }

    static void pattern31(int n){
        for (int i = 2*n; i > 1; i--) {
            int x=(i>=n+1)?i-n:2*n-i-2;
            for (int j = 2*n; j > 1; j--) {
                int y=(j>n+1)?j-n:2*n-j-2;
                System.out.print(Math.max(x, y)+" ");
//                if (x>y){
//                    System.out.print(x+" ");
//                }else {
//                    System.out.print(y+" ");
//                }
            }
            System.out.println();
        }
    }

    static void pattern28(int n){
        for (int i = 1; i < 2*n; i++) {
            int totalSpaces=i<=n?n-i:i-n;
            //int totalStars=i<=n?i:2*n-i;
            int totalStars=n-totalSpaces;
            //Spaces
            for (int j = 1; j <= totalSpaces; j++) {
                System.out.print(" ");
            }
            //Stars
            for (int k = 1; k <= totalStars; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern30(int n){
        for (int i = 1; i <= n; i++) {
            //left spaces
            for (int j = n; j >= i; j--) {
                System.out.print("  "); //Why double space here: If you give space for rest numbers or stars,
            }                           //then you also need give extra space here

            //Printing numbers till 1
            for (int j = i; j >= 1; j--) {
                System.out.print(j+" ");
            }
            //Printing numbers after 1
            for (int j = 2; j <= i; j++) {
                System.out.print(j+" ");
            }
            System.out.println();

        }
    }

    
    static void pattern3(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    //way-2: Of pattern-3
    static void pattern3way2(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n-i+1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }


    static void pattern1(int n){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n){
        for (int row = 1; row <= n; row++) {
            //for every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            //when one row is printed,we need to add a new line
            System.out.println();
        }
    }


}
