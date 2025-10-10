
public class Recursion {

   // 1st and last occurence in a string
   static void occurenceOfstring(String str, String s) {
      int first = -1, last = -1;
      int idx = 0;
      while (idx < str.length()) {
         if(str.charAt(idx) == s.charAt(0)){
            if (first == -1) {
               first = idx;
            }
            last = idx;
         }
         idx++;
      }
      System.out.println("First occurrence: " + first);
      System.out.println("Last occurrence: " + last);
   }

   static void OccurenceOfstringUsingRecursion(String str, String s, int idx) {
        int first = -1, last = -1;
        if (idx >= str.length()) {
            System.out.println("First occurrence: " + first);
            System.out.println("Last occurrence: " + last);
            return;
        }
        if (str.charAt(idx) == s.charAt(0)) {
            if (first == -1) {
                first = idx;
            }
            last = idx;
        }
        OccurenceOfstringUsingRecursion(str, s, idx + 1);
    }

    static boolean isSorted(int[] arr, int idx){
      if (idx == arr.length - 1) {
         return true;
      }
      if (arr[idx] > arr[idx + 1]) {
         return false;
      }
      return isSorted(arr, idx + 1);
    }
   

   static String RemoveDupString(String str) {
      boolean[] map = new boolean[256];
        // base case
        if (str.length() == 0) {
            return "";
        }

        char currChar = str.charAt(0);

        // if not visited, include it
        if (!map[currChar]) {
            map[currChar] = true;
            return currChar + RemoveDupString(str.substring(1));
        }

        // else skip it
        return RemoveDupString(str.substring(1));
    }


     
  
   public static void main(String[] args) {
      occurenceOfstring("abaacdaefeaah", "b");
   }
}
