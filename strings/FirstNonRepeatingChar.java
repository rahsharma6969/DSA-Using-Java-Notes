import java.util.*;

public class FirstNonRepeatingChar {
    // brute force
   
    static String FirstNonRepeatingChar(String s){

        for(int i=0; i<s.length(); i++){
            boolean flag = false;
            for(int j= 0; j<s.length(); j++){
                if(i != j && s.charAt(i) == s.charAt(j)){
                    flag = true;
                    break;
                }
            }
            if(flag == false){
                return String.valueOf(s.charAt(i));
            }
        }

        return "";
    }

    static String FirstNonRepeatingChar2(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i<s.length(); i++){  // Count frequency of each character
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<s.length(); i++){  // Find the first non-repeating character
            char ch = s.charAt(i);
            if(map.get(ch) == 1){
                return String.valueOf(ch);
            }
        }

        return "";
    }
    public static void main(String[] args) {
        String s = "aabbcddeef";
        System.out.println(FirstNonRepeatingChar(s)); // time complexity O(n^2)
        System.out.println(FirstNonRepeatingChar2(s)); // time complexity O(n)

        
    }
}
