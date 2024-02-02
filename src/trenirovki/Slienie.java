package trenirovki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Slienie {
    public static void main(String[] args) throws IOException {
        int[] firstArray;
        int[] secondArray;
        int[] result;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            String[] strArrN = reader.readLine().trim().split(" ");
            int m = Integer.parseInt(reader.readLine().strip());
            String[] strArrM = reader.readLine().trim().split(" ");
            firstArray = new int[n];
            secondArray = new int[m];
            for (int i = 0; i < n; i++) {
                firstArray[i] = Integer.parseInt(strArrN[i]);
            }
            for (int i = 0; i < m; i++) {
                secondArray[i] = Integer.parseInt(strArrM[i]);
            }
            result = merge(firstArray, secondArray);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : result) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }

    public static int[] merge(int[] firstArray, int[] secondArray) {
        int[] result = new int[firstArray.length + secondArray.length];
        int first = 0;
        int second = 0;
        int k = 0;
        while (first < firstArray.length && second < secondArray.length) {
            if (firstArray[first] <= secondArray[second]) {
                result[k] = firstArray[first];
                first++;
            } else {
                result[k] = secondArray[second];
                second++;
            }
            k++;
        }

        while (first < firstArray.length) {
            result[k] = firstArray[first];
            first++;
            k++;
        }
        while (second < secondArray.length) {
            result[k] = secondArray[second];
            second++;
            k++;
        }
        return result;
    }

}
