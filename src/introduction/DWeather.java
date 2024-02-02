package introduction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DWeather {
    public static void main(String[] args) throws IOException {
        int[] temperature;
        int n;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().strip());
            temperature = new int[n];
            String[] str = reader.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                temperature[i] = Integer.parseInt(str[i]);
            }
        }
        int result = chaoticWeather(temperature, n);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(result));
        writer.flush();
    }

    static int chaoticWeather(int[] temperature, int n) {
        if (n == 1) return 1;
        int count = 0;
        if (n > 1) {
            if (temperature[0] > temperature[1]) {
                count++;
            }
            if (temperature[n - 1] > temperature[n - 2]) {
                count++;
            }
            for (int i = 1; i < n - 1; i++) {
                if ((temperature[i] > temperature[i + 1]) && (temperature[i] > temperature[i - 1])) {
                    count++;
                }
            }
        }
        return count;
    }
}
