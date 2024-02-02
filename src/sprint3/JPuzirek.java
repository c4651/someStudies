package sprint3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class JPuzirek {
    public static void main(String[] args) throws IOException {
        int[] array;
        StringBuilder result;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            String[] strArr = reader.readLine().trim().split(" ");
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(strArr[i]);
            }
            result = bubbleSort(array, new StringBuilder(""));
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(result));
        writer.flush();
    }

    public static StringBuilder bubbleSort(int[] array, StringBuilder result) {
        boolean isSorted = true;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                isSorted = false;
            }
        }
        if (isSorted) {
            for (int i : array) {
                result.append(i).append(" ");
            }
            return result;
        }

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    isSorted = false;
                    swap(array, i);
                }
            }
            if (isSorted) {
                return result;
            }
            for (int j : array) {
                result.append(j).append(" ");
            }
            result.append("\n");
        }
        return result;
    }

    public static void swap(int[] arr, int i) {
        int temp = arr[i];
        arr[i] = arr[i + 1];
        arr[i + 1] = temp;
    }
}
