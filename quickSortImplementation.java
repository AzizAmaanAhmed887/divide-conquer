public class quickSortImplementation {
    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void quickSort(int[] arr, int si, int ei) {
        // base case
        if (si >= ei)
            return;
        // This fn put less element than pivot in left and greater at right part of pivot
        int pidx = partition(arr, si, ei);
        quickSort(arr, si, pidx - 1); // left part
        quickSort(arr, pidx + 1, ei); // right part
    }

    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1; // to make els smaller than pivot

        for (int j = 0; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 8, 2, 5};
        quickSort(arr, 0, arr.length - 1);
    }
}
