class Solution{
    // reversing a string without using inbuilt functions using two pointers approach
    public String revString(String str){

      for(int j=0; j<str.length()/2 ; j++){

        char temp = str.charAt(j);
        char ch = str.charAt(str.length() - 1 - j);
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(j, ch);
        sb.setCharAt(str.length() - 1 - j, temp);
        str = sb.toString();
      }
  return str;
   }
}

public class Reversestr {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String str = "Hello, World!";
        String reversed = sol.revString(str);
        System.out.println("Reversed String: " + reversed);
    }
}
