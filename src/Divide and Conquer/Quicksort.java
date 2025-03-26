public class Quicksort {
    public static void main(String args[]) {
        int testArr[] = { 4, 23, 6, 8, 90, 11, 0, -2, 2 };
        System.out.println("Initial array: ");
        printArray(testArr);
        
        qs(testArr, 0, testArr.length - 1);
        
        System.out.println("Sorted Array: ");
        printArray(testArr);
    }

    private static void qs(int arr[], int l, int h) {
        int part;
        if ((h-l) > 0) {
            part = partition(arr, l, h);
            System.out.println("Pivot positioned at index " + part + " with value " + arr[part]);
            printArray(arr);

            qs(arr, l, part - 1);
            qs(arr, part + 1, h);
        }

    }

    private static int partition(int arr[], int l, int h) {
        int pivot = h;
        int firstHigh = l;

        System.out.println("Partitioning with pivot " + arr[pivot] + " (index " + pivot + ")");

        for (int i = l; i < h; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, firstHigh);
                System.out.println("Swapped " + arr[firstHigh] + " and " + arr[i]);
                firstHigh++;
            }
        }
        swap(arr, pivot, firstHigh);
        System.out.println("Swapped pivot " + arr[firstHigh] + " into correct position");

        return firstHigh;
    }

    private static void swap(int arr[], int i1, int i2) {
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    private static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}