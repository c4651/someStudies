package trenirovki;
//https://www.geeksforgeeks.org/in-place-merge-sort/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MergeSort2 {
    public static void main(String[] args) throws IOException {
        int[] array;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            String[] strArr = reader.readLine().trim().split(" ");
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(strArr[i]);
            }
            mergeSort(array, 0, array.length - 1);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : array) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }


    private static int nextGap(int gap) {
        if (gap <= 1) {
            return 0;
        }
        return (int) Math.ceil(gap / 2.0);
    }


    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void merge(int[] nums, int start, int end) {
        int gap = end - start + 1;
        for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            for (int i = start; i + gap <= end; i++) {
                int j = i + gap;
                if (nums[i] > nums[j])
                    swap(nums, i, j);
            }
        }
    }

    public static void mergeSort(int[] nums, int l, int r) {
        if (nums.length == 0) {
            return;
        }
        if (l == r) {
            return;
        }
        int mid = (l + r) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, r);
    }
}
