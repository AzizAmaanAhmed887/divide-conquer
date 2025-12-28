public class Sorted_Rotated_Array_Search {
    public static int search(int[] arr, int target, int si, int ei) {
        // base case
        if (si > ei) {
            return -1;
        }
        // mid
        int mid = si + (ei - si) / 2;

        // base case
        if (arr[mid] == target) {
            return mid;
        }

        //for l1
        if (arr[si] <= arr[mid]) {
            if (arr[si] <= target && target < arr[mid]) {
                return search(arr, target, si, mid - 1); // left part searching
            } else {
                return search(arr, target, mid + 1, ei); // right part
            }
        }

        // for l2
        else {
            if (arr[mid] <= target && target <= arr[ei]) {
                return search(arr, target, mid + 1, ei); // right part
            } else {
                return search(arr, target, si, mid - 1); // left part
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 5;
        int targetIndex = search(arr, target, 0, arr.length - 1);
        System.out.println("Element " + target + " present at index " + targetIndex); // 4
    }
}
