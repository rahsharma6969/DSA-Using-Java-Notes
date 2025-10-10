
class Pyramid {
    void InvertedHalfPyramid() {
        int row = 4;

        for (int i = row; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    void Halfpyramid() {
        int row = 4;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    void InvertedRotatedHalfPyramid() {
        int row = 4;
        for(int i=1; i<=row; i++){
            for(int j=1; j<=row-i; j++){
                System.out.print(" ");
            }
            for(int j=1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    void PrintNumberPyramid(){
        int row =5;
        for(int i=1; i<=row;i++){
            for(int j=1; j<=i; j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }

    void FloydsTriangle(){
        int row =5;
        int count =1;
       for(int i=1; i<= row; i++){
        for(int j=1; j<=i; j++){
            System.out.print(count+" ");
            count++;
        }
        System.out.println();
       }
    }

    void ZeroOneTriangle(){
        int row =5;
        for(int i=1; i<=row; i++){
            for(int j=1; j<=i; j++){
                if((i+j)%2==0){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}

public class Halfpyramid {
    public static void main(String[] args) {
        Pyramid p = new Pyramid();
        // p.Halfpyramid();
        // p.InvertedHalfPyramid();
        // p.InvertedRotatedHalfPyramid();
        // p.PrintNumberPyramid();
        // p.FloydsTriangle();
        p.ZeroOneTriangle();

    }
}
/*
 * Output:
 * *
 * **
 * ***
 * ****
 */
