/*
 * Binary search time complexity: O(log n)
 */
public class BinarySearch {
    public static void main(String args[]) {
        int arr[] = {4, 6, 7, 13, 67, 99, 333, 339};
        System.out.println("The index of the element is " + binSearch(arr, 6, 0, arr.length));
    }   
    
    
    private static int binSearch(int arr[], int item, int low, int high) {
        System.out.println("\nCalling binary search on array");
        int middle;

        // either an error in input or element does not exist
        if (low > high) {
            System.out.println("\nEither the indexes are swapped or the element does not exist in the array");
            return -1;
        }
        
        // set the middle to the middle of the array or subarray we want to search
        middle = (low + high) / 2;
        for (int i = low; i < high; i++) {
            System.out.printf("%5d", arr[i]);
        }
        System.out.println();

        // if item is found, return it
        System.out.printf("\nDoes %d = %d?\n", arr[middle], item);
        if (arr[middle] == item) {
            System.out.println("Yes");
            return middle;
        }
        System.out.println("No");
        // check if item is greater than or less than the current middle value and recursively split the array
        System.out.printf("Is %d greater than %d?\n", arr[middle], item); 
        if (arr[middle] > item) {
            System.out.printf("Yes, calling binary search from %d to %d\n", low, (middle - 1));
            return binSearch(arr, item, low, middle - 1);
        } else {
            System.out.printf("No, calling binary search from %d to %d\n",(middle + 1), high);
            return binSearch(arr, item, middle+1, high);
        }
    }
}
