
public class Recursion {

 
    static void printNumber(int n){
      if(n ==0 ) return ;

      System.out.println(n);
      printNumber(n-1);
   }
   

   static int factorial(int n){
      if( n == 0 ) return 1;

      int fact = n * factorial(n-1);
       return fact; 
      }
   
   static int powerOfn(int x , int n){
       if( n == 0) return 1;
       if ( n== 1) return x;
       int power = x * powerOfn( x, n- 1);
       return power;
   }

   static String reverseString(String str){
      if (str.length() == 0) {
        return "";
    }

    return reverseString(str.substring(1)) + str.charAt(0); 
   }


 public static void main(String[] args) {
   // printNumber(5);
   System.out.println(factorial(5));

   }

  
    }


     
  
  
