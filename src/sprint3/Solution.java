package sprint3;

import java.util.Arrays;

public class Solution {
    public static int[] merge(int[] arr, int left, int mid, int right) {
        int[] leftPart = Arrays.copyOfRange(arr, left, mid);
        int[] rightPart = Arrays.copyOfRange(arr, mid, right);

        int l = 0, r = 0, k = left;
        while (l < leftPart.length && r < rightPart.length) {
            if (leftPart[l] <= rightPart[r]) {
                arr[k] = leftPart[l];
                l++;
            } else {
                arr[k] = rightPart[r];
                r++;
            }
            k++;
        }
        while (l < leftPart.length) {
            arr[k] = leftPart[l];   // перенеси оставшиеся элементы left в result
            l++;
            k++;
        }
        while (r < rightPart.length) {
            arr[k] = rightPart[r];  // перенеси оставшиеся элементы right в result
            r++;
            k++;
        }
        return null;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        if (right - left <= 1) {
            return;
        }
        int mid = (right + left) / 2;
        merge_sort(arr, left, mid - 1);
        merge_sort(arr, mid, right - 1);
        merge(arr, left, mid, right);
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 9, 2, 10, 11};
        int[] b = merge(a, 0, 3, 6);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        merge_sort(c, 0, 6);
        for (int i : c) {
            System.out.print(i + " ");
        }
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        assert Arrays.equals(c, expected2);
    }
}