
public class towerOfHanoi{

    static void tower(int n, char source, char helper, char dest) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + helper);
            return;
        }
        tower(n - 1, source, dest, helper);
        System.out.println("Move disk " + n + " from " + source + " to " + helper);
        tower(n - 1, dest, helper, source);
    }  
     public static void main(String[] args) {
        tower(3, 'S', 'H', 'D');
        
    }
}