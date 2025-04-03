// Dynamic Programming is a technique used to solve problems by breaking them into smaller overlapping subproblems and storing the results of these subproblems to avoid redundant calculations.

// There are two main approaches in DP:

// Top-Down (Memoization): Solve the problem recursively and store the results of subproblems to reuse later.
// Bottom-Up (Tabulation): Build the solution iteratively from the smallest subproblems up to the final result, using an array or variables to store intermediate results.


// Common Problem Types for Bottom-Up DP
// Sequence Problems

// Fibonacci Numbers
// Tribonacci Numbers (like the one you solved)
// Longest Increasing Subsequence
// Longest Common Subsequence
// Maximum Subarray Sum (Kadane’s Algorithm)
// Knapsack Problems

// 0/1 Knapsack Problem
// Unbounded Knapsack Problem
// Subset Sum
// Partition Equal Subset Sum
// Pathfinding Problems

// Unique Paths in a Grid
// Minimum Path Sum
// Climbing Stairs
// Coin Change (minimum coins needed to reach a value)
// String Problems

// Edit Distance (Levenshtein Distance)
// Longest Palindromic Subsequence
// Longest Palindromic Substring
// Regular Expression Matching
// Game Theory Problems

// Stone Game Variants
// Minimax Algorithm for decision making in two-player games
// Combinatorics and Counting Problems

// Counting the number of ways to reach a target (e.g., stairs or grid problems)
// Counting the number of binary search trees
// Partitioning Problems

// Matrix Chain Multiplication
// Palindrome Partitioning
// Graph Problems

// Shortest Path Algorithms (Dijkstra’s Algorithm, Floyd-Warshall)
// Bellman-Ford Algorithm
// All-Pairs Shortest Path
// Profit/Cost Optimization

// Cutting Rods for Maximum Profit
// Job Scheduling Problems
// Maximum Profit in Stock Trading


import java.util.Scanner;

public class FibonacciDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the value of n to compute the nth Fibonacci number:");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("Please enter a non-negative integer.");
        } else {
            int result = fibonacci(n);
            System.out.println("The " + n + "th Fibonacci number is: " + result);
        }

        sc.close();
    }

    // Bottom-Up Dynamic Programming approach
    public static int fibonacci(int n) {
        if (n == 0) {
            return 0; // Base case
        }
        if (n == 1) {
            return 1; // Base case
        }

        // Initialize the first two Fibonacci numbers
        int a = 0; // Fibonacci(0)
        int b = 1; // Fibonacci(1)
        int c = 0; // To store the current Fibonacci number

        // Compute Fibonacci numbers iteratively
        for (int i = 2; i <= n; i++) {
            c = a + b; // Compute Fibonacci(i)
            a = b;     // Shift the sequence: a becomes Fibonacci(i-1)
            b = c;     // b becomes Fibonacci(i)
        }

        return c; // Return the nth Fibonacci number
    }
}

