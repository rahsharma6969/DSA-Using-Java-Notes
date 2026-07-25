# DSA Using Java Notes

This repository contains Java solutions for common Data Structures and Algorithms problems. The questions are organized by topic and pattern so that they are easier to revise and practice.

## Repository Structure Overview

- Arrays and Matrix problems
- Strings and Character problems
- Sliding Window problems
- Binary Search problems
- Recursion and Backtracking problems
- Graph problems
- Dynamic Programming problems
- Tree problems
- Heap and Priority Queue problems
- Linked List problems
- HashMap problems
- Stack and Queue problems
- Sorting and Math practice

---

## Pattern-Based Classification

This repository can also be studied by algorithmic pattern instead of only by folder.

### 1. Two Pointers
Used for problems involving pairs, sorted arrays, and in-place scanning.

- [array/ContainerWithMostWater.java](array/ContainerWithMostWater.java)
- [array/Movezero.java](array/Movezero.java)
- [array/ValidParanthesis.java](array/ValidParanthesis.java)
- [strings/ValidPalindrom.java](strings/ValidPalindrom.java)

### 2. Sliding Window
Used for contiguous subarrays or substrings with constraints.

- [slidingwindow/MaxSubarrOfSizek.java](slidingwindow/MaxSubarrOfSizek.java)
- [slidingwindow/LongestSubStringWithKUniques.java](slidingwindow/LongestSubStringWithKUniques.java)
- [slidingwindow/MinWindowSubstring.java](slidingwindow/MinWindowSubstring.java)
- [slidingwindow/BinarySubArrayWithSum.java](slidingwindow/BinarySubArrayWithSum.java)

### 3. Binary Search
Used when the problem has sorted data and requires efficient search.

- [BinarySearch/BinarySearch.java](BinarySearch/BinarySearch.java)
- [BinarySearch/SearchInsertPosition.java](BinarySearch/SearchInsertPosition.java)
- [BinarySearch/FindMinInRotatedSortedArr.java](BinarySearch/FindMinInRotatedSortedArr.java)
- [BinarySearch/kokoEatingBanana.java](BinarySearch/kokoEatingBanana.java)

### 4. Recursion
Used for divide-and-conquer style problems and smaller sub-problems.

- [recursion/basics/FindmaxRecursion.java](recursion/basics/FindmaxRecursion.java)
- [recursion/basics/FindMinRecursion.java](recursion/basics/FindMinRecursion.java)
- [recursion/string-and-array/palindromeRecursion.java](recursion/string-and-array/palindromeRecursion.java)
- [recursion/number-and-math/towerOfHanoi.java](recursion/number-and-math/towerOfHanoi.java)

### 5. Backtracking
Used for generating combinations, permutations, subsets, or solving constraint-based problems.

- [recursion/backtracking/CombinationSumI.java](recursion/backtracking/CombinationSumI.java)
- [recursion/backtracking/Permutation.java](recursion/backtracking/Permutation.java)
- [recursion/backtracking/Subsets.java](recursion/backtracking/Subsets.java)
- [recursion/backtracking/PalindromePartitioning.java](recursion/backtracking/PalindromePartitioning.java)
- [recursion/backtracking/SudokuSolver.java](recursion/backtracking/SudokuSolver.java)

### 6. Graph Traversal
Used for traversing connected components, cycles, and shortest paths.

- [Graphs/BFS.java](Graphs/BFS.java)
- [Graphs/DFS.java](Graphs/DFS.java)
- [Graphs/NoOFIslands.java](Graphs/NoOFIslands.java)
- [Graphs/TopologicalSort.java](Graphs/TopologicalSort.java)

### 7. Dynamic Programming
Used for optimization problems where subproblems overlap.

- [DP/1DArray-DP/Fibonacci.java](DP/1DArray-DP/Fibonacci.java)
- [DP/1DArray-DP/ClimbingStair.java](DP/1DArray-DP/ClimbingStair.java)
- [DP/1DArray-DP/HouseRobber.java](DP/1DArray-DP/HouseRobber.java)
- [DP/Subset/SubsetSumEqualsTarget.java](DP/Subset/SubsetSumEqualsTarget.java)
- [DP/2D-DP/UniquePaths.java](DP/2D-DP/UniquePaths.java)

### 8. Tree Traversal and Tree-Based Problems
Used for binary tree and BST-related traversal and structure problems.

- [Trees/BinaryTrees/BinaryTree.java](Trees/BinaryTrees/BinaryTree.java)
- [Trees/BinaryTrees/Diameter.java](Trees/BinaryTrees/Diameter.java)
- [Trees/BinaryTrees/LowestCommonAncestor.java](Trees/BinaryTrees/LowestCommonAncestor.java)
- [Trees/BinarySearchTree/isBST.java](Trees/BinarySearchTree/isBST.java)

### 9. Heap / Priority Queue
Used for top-k problems and ordering under constraints.

- [PriorityQueue/kthLargestElement.java](PriorityQueue/kthLargestElement.java)
- [PriorityQueue/TopKfreqElements.java](PriorityQueue/TopKfreqElements.java)
- [PriorityQueue/MergekSortedList.java](PriorityQueue/MergekSortedList.java)

### 10. Stack and Queue
Used for LIFO/FIFO style operations and monotonic structures.

- [QueueAndStack/MinStack.java](QueueAndStack/MinStack.java)
- [QueueAndStack/MaxSlidingWindow.java](QueueAndStack/MaxSlidingWindow.java)
- [QueueAndStack/DecodeString.java](QueueAndStack/DecodeString.java)
- [QueueAndStack/AstroidCollision.java](QueueAndStack/AstroidCollision.java)

### 11. HashMap / Hashing
Used for frequency counting, lookup, and duplicate detection.

- [hashmap/containsDuplicate.java](hashmap/containsDuplicate.java)
- [hashmap/HappyNumber.java](hashmap/HappyNumber.java)
- [hashmap/LongestCOnsectutiveNumber.java](hashmap/LongestCOnsectutiveNumber.java)
- [hashmap/IntersectionTwoArr.java](hashmap/IntersectionTwoArr.java)

---

## 1. Arrays and Matrices

Folder: [array](array)

This folder contains array-based problems focused on indexing, duplicates, sorting, subarrays, and matrix-style traversal.

### Questions covered
- Two Sum
- Contains Duplicate
- Find Duplicate
- Remove Duplicates
- Move Zeroes
- Rotate Array
- Merge Two Sorted Arrays
- Product of Array Except Self
- Maximum Subarray Sum
- Subarray Sum Equals K
- Three Sum
- Three Sum Closest
- Sort Colors
- Container With Most Water
- Next Permutation
- Valid Parentheses

---

## 2. Strings and Character Problems

Folder: [strings](strings)

This folder covers string manipulation, anagrams, palindrome checks, and frequency-based string problems.

### Questions covered
- Reverse String
- Reverse Words in a String
- Valid Palindrome
- Valid Anagram
- First Unique Character
- First Occurrence of a Character
- Reverse K Characters
- String Compression
- Permute Characters

---

## 3. Sliding Window

Folder: [slidingwindow](slidingwindow)

These problems are based on the sliding window pattern for subarray and substring optimization.

### Questions covered
- Maximum Sum of Subarray of Size K
- Longest Substring Without Repeating Characters
- Longest Repeating Character Replacement
- Minimum Window Substring
- Minimum Size Subarray Sum
- Longest Substring with K Unique Characters
- Binary Subarray With Sum
- Fruit in Basket
- Maximum Consecutive Ones
- Maximum Average Subarray
- Max Points From Cards
- No of Subarrays

---

## 4. Binary Search

Folder: [BinarySearch](BinarySearch)

These solutions use the binary search technique on sorted arrays and search spaces.

### Questions covered
- Binary Search
- Search Insert Position
- First and Last Position of Element
- Find Minimum in Rotated Sorted Array
- Search in Rotated Array
- Search in Rotated Array II
- Find Peak Element
- Capacity To Ship Packages
- Koko Eating Bananas
- First Bad Version
- Square Root
- Valid Perfect Square

---

## 5. Recursion and Backtracking

Folder: [recursion](recursion)

This section contains recursive solutions and backtracking-based combinational problems.

### Subfolders
- [recursion/basics](recursion/basics) - basic recursion practice such as finding max/min and simple recursive patterns
- [recursion/backtracking](recursion/backtracking) - combination, permutation, subset, partitioning, and Sudoku-style problems
- [recursion/string-and-array](recursion/string-and-array) - recursion on strings and arrays
- [recursion/stack-and-data-structures](recursion/stack-and-data-structures) - recursive operations on stacks
- [recursion/number-and-math](recursion/number-and-math) - recursion on mathematical problems like Tower of Hanoi

### Questions covered
- Find Maximum Recursively
- Find Minimum Recursively
- Reverse String Recursively
- Palindrome Recursion
- Combination Sum I and II
- Generate Parentheses
- Generate Binary Strings
- Permutations
- Permutation Sequence
- Subsets and Subsequence Problems
- Palindrome Partitioning
- M-Coloring Problem
- Sudoku Solver
- Tower of Hanoi
- Reverse Stack
- Sort Stack

---

## 6. Graph Problems

Folder: [Graphs](Graphs)

These problems focus on graph traversal, cycle detection, shortest path, and connectivity.

### Questions covered
- BFS and DFS traversal
- Number of Islands
- Number of Provinces
- Flood Fill
- Rotten Oranges
- Bipartite Graph
- Cycle Detection in Directed and Undirected Graphs
- Topological Sort
- Course Schedule I and II
- Dijkstra Algorithm
- Eventual Safe States
- Distance to Nearest Cell

---

## 7. Dynamic Programming

Folders: [DP](DP)

This folder contains DP problems solved using 1D, 2D, subset, and string DP patterns.

### Questions covered
- Fibonacci
- Climbing Stairs
- Frog Jump
- House Robber
- House Robber II
- Maximum Sum of Non-Adjacent Elements
- Minimum Cost Climbing Stairs
- Unique Paths
- Unique Paths II
- Triangle
- Ninja Training
- Minimum Path Sum
- Minimum Falling Path Sum
- Longest Common Subsequence
- Subset Sum Problems
- Partition Equal Subset Sum

---

## 8. Trees

Folder: [Trees](Trees)

Tree solutions focus on traversal, balancing, path, and structure-based problems.

### Questions covered
- Binary Tree Basics
- Diameter of Binary Tree
- Balanced Binary Tree
- Invert Binary Tree
- Lowest Common Ancestor
- Deepest Node
- Root to Node Path
- Symmetric Tree
- Top View of Binary Tree
- ZigZag Level Order Traversal
- Binary Search Tree checks

---

## 9. Heap and Priority Queue

Folder: [PriorityQueue](PriorityQueue)

These problems use heaps or priority queues for ordering and top-k selection.

### Questions covered
- Kth Largest Element
- K Closest Points
- Merge k Sorted Lists
- Top K Frequent Elements
- Min Cost to Hire K Workers

---

## 10. Linked List

Folder: [LinkedList](LinkedList)

Linked list solutions cover traversal, reversal, cycle detection, and middle-node problems.

### Questions covered
- Reverse Linked List
- Middle of Linked List
- Detect Cycle in Linked List
- Remove Nth Node from End

---

## 11. HashMap

Folder: [hashmap](hashmap)

These problems focus on hash-based lookup, duplicates, and frequency counting.

### Questions covered
- Contains Duplicate
- Happy Number
- Jewels and Stones
- Intersection of Two Arrays
- Longest Consecutive Sequence
- Single Number

---

## 12. Stack and Queue

Folder: [QueueAndStack](QueueAndStack)

This section contains stack and queue-based problems, especially around valid parentheses, monotonic stacks, and sliding window optimization.

### Questions covered
- Valid Parentheses
- Min Stack
- Daily Temperatures
- Next Greater Element
- Previous Smaller Element
- Largest Rectangle in Histogram
- Decode String
- Remove K Digits
- Asteroid Collision
- Sum of Subarray Minimums
- Max Sliding Window
- Score of Valid Parentheses

---

## 13. Sorting and Math

Folders: [sorting](sorting), [Maths](Maths), [patterns](patterns)

These files focus on foundational logic, sorting techniques, and pattern-based practice.

### Questions covered
- Merge Sort
- Sort practice
- Prime Number
- Digits manipulation
- Pattern printing problems like Hollow Rectangle, Solid Rectangle, Butterfly, and Half Pyramid

---

## 14. Extra Practice and Miscellaneous

Folders: [Infosys](Infosys), [tcs-nqt](tcs-nqt), [threads](threads)

These contain extra interview-style questions and practice exercises.

---

## How to Use This Repository

- Start with the pattern-based folders such as Arrays, Strings, Sliding Window, Binary Search, and Recursion.
- Practice one pattern at a time before moving to DP, Trees, and Graphs.
- Use the folder names as a revision map when preparing for coding interviews.

---

## Goal of This Repository

The main goal of this repository is to build strong problem-solving habits in Java by solving questions from common DSA patterns and interview topics.
