public class SolidRectangle {

    public static void main(String[] args) {
        int row = 4;
        int col = 5;

        for(int i=1; i<= row; i++){
            for(int j=1; j<= col; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
