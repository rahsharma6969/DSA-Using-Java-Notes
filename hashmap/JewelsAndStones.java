import java.util.*;
class Solution{
    public int numJewelsInStones(String jewels, String stones) {
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char stone : stones.toCharArray()){
            map.put(stone, map.getOrDefault(stone, 0) + 1);
        }
        for(char jewel : jewels.toCharArray()){
            if(map.containsKey(jewel)){
                count += map.get(jewel);
            }
        }
        return count;
    }
}



public class JewelsAndStones {
    public static void main(String[] args) {
        
    }
}
