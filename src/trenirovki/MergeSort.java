package trenirovki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;


public class MergeSort {
    public static void main(String[] args) throws IOException {
        int[] array;
        int[] result;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            String[] strArr = reader.readLine().trim().split(" ");
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(strArr[i]);
            }
            result = mergeSort(array);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : result) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }

    public static void mergeBlocks(int[] array, int len0, int len1) {
        if (len0 <= 0 || len1 <= 0) {
            return;
        }
        int n = len0 + len1;
        if (len0 == 1) {
            int k = 0;
            for (int i = len0 - 1; i >= 1; i--){
                if (array[0] == array[i]){
                    k = i;
                }
            }
            int i = 0;
            while (i<k) {
                swapBlocks(array, i, i+1, 0);
                ++i;
            }
            return;
        } else if (len1 == 1) {
            int k = 0;
            for (int i = len1 - 1; i >= len0; i--) {
                if (array[len0] == array[i]) {
                    k = i;
                }
            }
            int i = 0;
            while (i < k) {
                swapBlocks(array, i, i + 1, 0);
                ++i;
            }
            return;
        }
        if (len0 > 1 && len1 >1) {
            int c0, c1;
            if (len0 >= len1) {
                c0 = len0/2;
                c1 = 0;
                for (int i = len1 - 1; i >= len0; i--){
                    if (array[c0] == array[i]){
                        c1 = i;
                    }
                }
                swapBlocks(array, len0, c1, c0);
            } else {
                c1 = len1/2;
                c0 = 0;
                for (int i = len0 - 1; i >= 0; i--){
                    if (array[c0] == array[i]){
                        c0 = i;
                    }
                }
                //swapBlocks(array, );
            }
        }

    }

    public static void swapBlocks(int[] array, int len0, int len1, int begin) {
        if (len0 <= 0 || len1 <= 0) {
            return;
        }
        reverseArray(array, begin, len0);
        reverseArray(array, len0, len1);
        reverseArray(array, begin, len0 + len1);
    }

    public static void reverseArray(int[] array, int left, int right) {
        int i = left;
        int j = right;
        while (i < j) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        }
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, array.length / 2));
        int[] right = mergeSort(Arrays.copyOfRange(array, array.length / 2, array.length));
        return new int[2];
    }
}
