package trenirovki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ESredniUroven {
    public static void main(String[] args) throws IOException {
        int[] array;
        int[] result;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            String[] strArr = reader.readLine().trim().split(" ");
            array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = Integer.parseInt(strArr[j]);
            }
            result = dissatisfactionLevel(array);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : result) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }

    public static int[] dissatisfactionLevel(int[] array) {
        int[] result1 = new int[array.length];
        int[] result2 = new int[array.length];
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            result1[i] = i * array[i] - sum;
            sum += array[i];
        }
        sum = 0;
        int n = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            result2[i] = sum - (n * array[i]);
            sum += array[i];
            n += 1;
        }
        for (int i = 0; i < array.length; i++) {
            result1[i] += result2[i];
        }
        return result1;
    }
}
