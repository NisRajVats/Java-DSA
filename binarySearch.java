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
    }
}