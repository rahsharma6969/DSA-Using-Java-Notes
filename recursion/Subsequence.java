public class Subsequence {

    static void printsubsequences(String str , int index, String current){
        // base case 
        if(str.length() == index){
            System.out.println(current);
            return;
        }

 
        // include the current character
        printsubsequences(str, index + 1, current + str.charAt(index));
        // exclude the current character
        printsubsequences(str, index + 1, current);
    }
    public static void main(String[] args) {
        String str = "abc";
        printsubsequences(str, 0, "");
    }
}
