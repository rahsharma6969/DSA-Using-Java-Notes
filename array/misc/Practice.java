import java.util.*;

public class Practice {

    // find duplicate in array
     static List<Integer> findAllDuplicates(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> duplicates = new ArrayList<>();

        // Count frequency of each element
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Collect all elements with frequency > 1
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.add(entry.getKey()); // adding only the duplicate number once
            }
        }

        return duplicates;
    }
    
    //missing number in array
    static int missingNumber(int[] arr){
        int n = arr.length;
        int expectedSum = n*(n+1)/2;
        int actualSum = 0;

        // for(int num : arr){
            
        //     actualSum += num;
        // }
        for(int i=0; i<n; i++){
            actualSum += arr[i];
        }
        return expectedSum - actualSum;
    }

    // Binary Search 
    static int binarySearch(int[] arr, int target){
        int left= 0; 
        int right = arr.length - 1;
        int mid = left + (right - left)/ 2;

        while(left <= right){
            if(arr[mid] == target){
               
                return mid;
            }
            else if(arr[mid]< target){
                left = mid + 1;
            } 
            else {
                right = mid - 1;
            }

        }
        return -1;
    }

    //string rotation
    static boolean stringRotation(String s1 , String s2){
        if (s1.length() != s2.length()){
            return false;
        }
        String temp = s1 + s1;
        // return temp.contains(s2);
        return temp.indexOf(s2) != -1;

    }
    // Pythorean triplet less then given number
    static int pythagoriantriplet(int number){
        int[][] triplets = new int [100][3];
        int count = 0;
        for(int a =1; a<number;a++){
            for(int b= a; b<number; b++){
                int c = (int)Math.sqrt(a*a + b*b);
                if(c*c == a*a + b*b && c<number){
                    triplets[count][0] = a;
                    triplets[count][1] = b;
                    triplets[count][2] = c;
                    count++;
                }
            }
        }

        for(int i=0; i<count; i++){
            System.out.println(triplets[i][0] + " " + triplets[i][1] + " " + triplets[i][2]);
        }
        return count;
    }
    
    //identical 2-D array
    static String identical2DArray(int[][] arr1, int[][] arr2){
        int n = arr1.length; // no of rows
        int m = arr1[0].length; // no of columns

        for(int i=0; i<n;i++){
            for(int j= 0;j<m; j++){
                if(arr1[i][j] != arr2[i][j]){
                    return "Not Identical";
                }
            }

        }
        
        return "Identical";
    }
    

    // couting valley problem
    static int countingValley(String s){
        int valley= 0;
        int level = 0;


        for(int i = 0 ; i< s.length(); i++){
            if(s.charAt(i) == 'U'){
                level++;
                if(level == 0){
                    valley++;
                }
            }else{
                level--;
            }
            }
            return valley;
        }
    
    
    // remov # from a given string
    static String removeHashString(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch != '#'){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // Minimum discount of a shop 
    static void minDiscount() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of items:");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        String[] names = new String[n];
        int[] discounts = new int[n];
        int minDiscount = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the item details (name,price,discount):");
            String input = sc.nextLine();

            // split by comma
            String[] parts = input.split(",");
            String name = parts[0].trim();
            int price = Integer.parseInt(parts[1].trim());
            int discount = Integer.parseInt(parts[2].trim());

            names[i] = name;
            discounts[i] = discount;

            // track minimum discount
            if (discount < minDiscount) {
                minDiscount = discount;
            }
        }

        System.out.println("\nItems with minimum discount (" + minDiscount + "%):");
        for (int i = 0; i < n; i++) {
            if (discounts[i] == minDiscount) {
                System.out.println(names[i]);
            }
        }
    }

   
    // Function to count occurrences of each element in the array
    static int OccurenceOfEachElement(int[] arr){
        Map<Integer, Integer> map = new HashMap<>();
        // count frequency of elements in map

        for(int i=0; i<arr.length; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // print frequency of each element
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());

        }


        
         return 0;
    } 

    // prime number
    static boolean isPrime(int n){
        if(n<=1) return false;

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n % i == 0){
                return false;
                
            }
         
        }
        return true;
       
    }
    //  Intersection of two arrays
    static int[] intersection(int[] arr1, int[] arr2){
        Set<Integer> set  = new HashSet<>();

        for(int num : arr1){  // add elements of arr1 to set
            set.add(num);
        }

        List<Integer> intersectionList = new ArrayList<>();
        for(int num : arr2){  // check elements of arr2 in set
            if(set.contains(num)){
                intersectionList.add(num);
                set.remove(num); // to avoid duplicates in intersection
            }
        
    }
    return intersectionList.stream().mapToInt(i -> i).toArray();

}

    // rotate array
    static void rotateArray(int []arr, int k){
        int lastIndex = arr.length -1;
        k = k % arr.length; // in case k is greater than array length

        while(k>0){
            int lastElement = arr[lastIndex];
            for(int i= lastIndex; i>0; i--){
                arr[i] = arr[i-1];
            }
            arr[0] = lastElement;
            k--;

        }
        
        System.out.println(Arrays.toString(arr));


    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3,3, 4,1,4,2,5,2, 5};
        int n = arr.length;

        // int result = OccurenceOfEachElement(arr);
        // System.out.println("Result: " + result);

        // int result = minDiscount();
        // System.out.println("Result: " + result);

        // String str = "a#b#c#d#e#f#g#h#i#j#k#l#m#n#o#p#q#r#s#t#u#v#w#x#y#z#";
        // String result = removeHashString(str);
        // System.out.println("Result: " + result);

    //     int result = countingValley("UDDDUDUU");
    //     System.out.println("Result: " + result);
         
        int[][] arr1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] arr2 = {
            {1, 2, 3},
            {4, 5,45},
            {7, 8, 9}
        };

        // String result = identical2DArray(arr1, arr2);
        // System.out.println("Result: " + result);


        // int result = pythagoriantriplet(20);
        // System.out.println("Result: " + result);

        // boolean result = stringRotation("ABCDE", "ABCDE");
        // System.out.println("Result: " + result);


        // int[] arr3 = {1,2,3,4,5,6,7,8,9};
        // int target = 5;
        
       
        // int result = binarySearch(arr3, target);
        // if(result == -1){
        //     System.out.println("Element not found in the array");
        // } else {
        //     System.out.println("Element found at index: " + result);
        // }

        // int [] arr4 = {0,1,2,4,5,6,7,8,9};
        // int result = missingNumber(arr4);
        // System.out.println("Missing number is: " + result);

        // int[] arr5 = {1,2,3,4,5,5,6,1,8,9};
       
        // System.out.println("Duplicate number is: " + findAllDuplicates(arr5));

        System.out.println(isPrime(11));

        // rotate array
        int[] arr6 = {1,2,3,4,5,6,7};
        int k = 3;
        rotateArray(arr6, k);


    }
}
