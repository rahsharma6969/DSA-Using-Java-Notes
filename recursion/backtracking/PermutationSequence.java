/*Permutation Sequence
Subscribe to TUF+

Hints
Company
Given two integers n and k, return the k-th permutation sequence of the numbers [1, 2, 3, ..., n].



The permutations are arranged in lexicographic order (i.e., dictionary order).



You must solve the problem without generating all permutations explicitly.


Example 1

Input: n = 3, k = 3

Output: "213"

Explanation: The permutations in order are:

1. 123
2. 132
3. 213 ← K = 3
4. 231
5. 312
6. 321 */

import java.util.ArrayList;
import java.util.List;

class Solution {

    public void solver(int n, int k, StringBuilder path, List<String> result) {
        if (path.length() == n) {
            result.add(path.toString());
            return;
        }

        if (result.size() == k) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (path.indexOf(String.valueOf(i)) != -1) { // Check if the number is already in the path so we don't repeat it
                continue;
            }

            path.append(i);
            solver(n, k, path, result);
            path.deleteCharAt(path.length() - 1);

            if (result.size() == k) {
                return;
            }
        }
    }

    public String getPermutation(int n, int k) {
        List<String> result = new ArrayList<>();
        solver(n, k, new StringBuilder(), result);
        return result.get(k - 1);
    }
}

public class PermutationSequence {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 3;
        int k = 5;
        String kthPermutation = solution.getPermutation(n, k);
        System.out.println(kthPermutation); // Output: "213"
    }
}
