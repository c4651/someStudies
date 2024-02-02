package trenirovki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) throws IOException {
        int[] array;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            String[] strArr = reader.readLine().trim().split(" ");
            array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = Integer.parseInt(strArr[j]);
            }
            quickSort(array, 0, array.length - 1);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : array) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }

    public static int[] partition(int[] array, int pivot) {
        int e = 0, g = 0, n = 0;
        while (n < array.length) {
            if (array[n] < pivot) {
                swap(array, e, n);
                swap(array, g, n);
                e++;
                g++;
                n++;
            } else if (array[n] == pivot) {
                swap(array, g, n);
                g++;
                n++;
            } else {
                n++;
            }
        }
        return new int[] {e, g};
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (begin < end) {
            Random random = new Random();
            int pivot = array[random.nextInt(array.length)];
            int[] parts = partition(array, pivot);
            quickSort(array, begin, parts[0]);
            quickSort(array, parts[1], end);
        }
    }
}



