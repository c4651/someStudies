package trenirovki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Solution2 {
    public static void main(String[] args) throws IOException {
        int[] array;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            String[] strArr = reader.readLine().trim().split(" ");
            array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = Integer.parseInt(strArr[j]);
            }
            quicksort(array, 0, array.length - 1);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : array) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }

    static int partition(int array[], int start, int end) {
        int rIndex = (start) + (int)(Math.random() * (end - start + 1));
        swap(array, start, rIndex);
        int pivot = array[start];
        int i = start - 1, j = end + 1;

        while (true) {
            do {
                i++;
            } while (array[i] < pivot);
            do {
                j--;
            } while (array[j] > pivot);

            if (i >= j) {
                return j;
            }
            swap(array, i, j);
        }
    }

    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quicksort(int array[], int start, int end) {
        if (start < end) {
            int point = partition(array, start, end);
            quicksort(array, start, point - 1);
            quicksort(array, point + 1, end);
        }
    }
}
