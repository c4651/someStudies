package trenirovki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ANeMinimumNaOtrezke {
    public static void main(String[] args) throws IOException {
        int[] array;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = reader.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            String[] strArr = reader.readLine().trim().split(" ");
            array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = Integer.parseInt(strArr[i]);
            }
            for (int i = 0; i < m; i++) {
                String[] indexes = reader.readLine().trim().split(" ");
                notMin(array, Integer.parseInt(indexes[0]), Integer.parseInt(indexes[1]));
            }
        }
    }

    public static void notMin(int[] array, int left, int right) throws IOException {
        int min = 1001;
        int index = -1;
        String result;
        for (int i = left; i <= right; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        for (int i = left; i <= right; i++) {
            if (array[i] > min) {
                index = i;
            }
        }
        if (index == -1) {
            result = "NOT FOUND";
        } else {
            result = String.valueOf(array[index]);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(result);
        writer.write("\n");
        writer.flush();
    }

}
