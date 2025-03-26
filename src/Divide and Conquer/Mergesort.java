public class Mergesort {

    public static void main(String args[]) {
        int testArr[] = { 12, 44, 24, 6, 1, 455, 2, 6 };
        sort(testArr, 0, testArr.length - 1);
    }

    private static void merge(int arr[], int l, int m, int r) {
        System.out.print("\nCalling merge on array: ");
        printArray(arr, l, r);

        // find sizes of two subarrays to be merged
        int n1 = (m - l) + 1;
        int n2 = r - m;

        // create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];

        // copy data
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[l + i];
        }
        System.out.print("\nCreating temp array L: ");
        printArray(arr, l, r);
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[m + 1 + j];
        }
        System.out.print("Creating temp array R: ");
        printArray(arr, l, r);
        
        // merge the temp arrays

        // initial indices of first and second subarrays
        int i = 0, j = 0;

        // initial index of merged subarray
        int k = l;
        System.out.println("\nMerging temp arrays into original array");
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                System.out.println(L[i] + " <= " + R[j]);
                arr[k] = L[i];
                System.out.println("Putting " + L[i] + " in original array at index " + k);
                i++;
            } else {
                System.out.println(L[i] + " > " + R[j]);
                arr[k] = R[j];
                System.out.println("Putting " + R[j] + " in original array at index " + k);
                j++;
            }
            k++;
        }

        // copy remaining elements of L[]
        System.out.println("Copying any remaining elements of L temp array to original array");
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // copy remaining elements of R[]
        System.out.println("Copying any remaining elements of R temp array to original array");
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        System.out.println("Array after merging: ");
        printArray(arr, 0, arr.length - 1);
    }

    // main function that sorts arr[L...r] using merge()
    private static void sort(int arr[], int l, int r) {
        System.out.print("\nCaling sort on array: ");
        printArray(arr, l, r);

        if (l < r) {
            // find middle point
            int m = (l + (r - 1)) / 2;
            System.out.println("Middle point is index " + m);

            // sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);

            // merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    private static void printArray(int arr[], int l, int n) {
        for (int i = l; i <= n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
