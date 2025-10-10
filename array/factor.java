import java.util.*;

public class factor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        List<Integer> factors = new ArrayList<>();

        for(int i = 1; i<=num; i++){
            if (num % i == 0){
                factors.add(i);
            }
        }

        System.out.println("Result :"+ factors);


    }
}
