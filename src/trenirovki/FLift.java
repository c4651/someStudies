package trenirovki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FLift {
    public static void main(String[] args) throws IOException {
        int[] array;
        int result;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int k = Integer.parseInt(reader.readLine().strip());
            int n = Integer.parseInt(reader.readLine().strip());
            array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = Integer.parseInt(reader.readLine().strip());
            }
            result = countSeconds(array, k);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(result);
        writer.flush();
    }

    public static int countSeconds(int[] array, int k) {


        return 0;
    }
}
