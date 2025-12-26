public class mergeSortQuestion {
    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
    }

    public static void mergeSort(int[] arr, int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;

        // left - right part will be solved
        mergeSort(arr, si, mid); // left part si = 0, ei = mid
        mergeSort(arr, mid + 1, ei); // right part si = mid+1, ei = ei

        // now 'merge' will be performed
        merge(arr, si, mid, ei);
    }

    public static void merge(int[] arr, int si, int mid, int ei) {
        int[] temp = new int[ei - si + 1];
        int i = si; // iterator for left part
        int j = mid + 1; // iterator for right part
        int k = 0; // iterator for temp array
        while (i <= mid && j <= ei) {
            // temp[k] = Math.min(arr[i], arr[j]); // another way tp write same statement
            if (arr[i] <= arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        // for leftover elements of left and right part
        // left part
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // copy all temp[] elements to original arr[]
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 3, 9, 5, 2, 8};
        printArray(arr); // original array
        System.out.println();
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr); // sorted array
    }
}