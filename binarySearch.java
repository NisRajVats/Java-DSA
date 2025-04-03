import java.util.Scanner;

public class binarySearch {
    // Binary search function
    public static int findquery(int arr[], int query) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // Corrected mid calculation******************

            if (query == arr[mid]) {
                return mid;
            } else if (query < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }?"
    {\]ublic static void main(String[] args) {''
        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter the size of the array: ");
        int size = sc.nextInt();
        int arr[] = new int[size];

        // Input array elements
        System.out.println("Enter the elements of the sorted array:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Input query
        System.out.print("Which element do you want to search: ");
        int query = sc.nextInt();

        // Call binary search function
        int result = findquery(arr, query);

        // Output result
        if (result == -1) {
            System.out.println("Query not found.");
        } else {
            System.out.println("Query is found at index: " + result);
        }

        sc.close();
    }
}
