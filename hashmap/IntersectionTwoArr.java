
import java.util.HashMap;


class Solution {
    public int[] intersection(int[] nums1, int[] nums2){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        HashMap<Integer, Integer> intersectionMap = new HashMap<>();
        for(int num : nums2){
            if(map.containsKey(num)){
                intersectionMap.put(num, intersectionMap.getOrDefault(num, 0) + 1);
            }
        }
        int[] result = new int[intersectionMap.size()];
        int index = 0;
        for(int key : intersectionMap.keySet()){
            result[index++] = key;
        }
        return result;
    }
}


public class IntersectionTwoArr {
    public static void main(String[] args) {
        
    } 
}
