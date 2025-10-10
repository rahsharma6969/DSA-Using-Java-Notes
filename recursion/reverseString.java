public class reverseString {

    static void reverse(String str){
        int idx = str.length();
        if(idx == 0 ){
             return ;
        }
        System.out.println(str.charAt(idx-1));
        reverse(str.substring(0, idx - 1));
    }
 public static void main(String[] args) {
    reverse("abcd");
 }   
}
