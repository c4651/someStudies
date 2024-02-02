//92540040
package introduction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NearestZero {
    public static void main(String[] args) throws IOException {
        int n;
        List<Integer> houses;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().strip());
            houses = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : solution(houses, n)) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }

    static int[] solution(List<Integer> houses, int n) {
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = houses.get(i);
        }

        int left = 0;
        for (int i = 0; i < n; i++) {
            if (result[i] == 0) {
                left = i;
                break;
            }
        }

        int k = 0;
        if (left > 0) {
            for (int i = left - 1; i >= 0; i--) {
                result[i] = ++k;
            }
        }

        int right = n;
        for (int i = n - 1; i >= 0; i--) {
            if (result[i] == 0) {
                right = i;
                break;
            }
        }

        k = 0;
        if (right < n) {
            for (int i = right + 1; i < n; i++) {
                result[i] = ++k;
            }
        }

        while (right > left) {
            int newLeft = 0;
            for (int i = left + 1; i < n; i++) {
                if (result[i] == 0) {
                    newLeft = i;
                    break;
                }
            }
            int middle = (newLeft - left) / 2;
            k = 0;
            for (int i = left + 1; i <= left + middle; i++) {
                result[i] = ++k;
            }
            k = 0;
            for (int i = newLeft - 1; i >= newLeft - middle; i--) {
                result[i] = ++k;
            }
            left = newLeft;
        }
        return result;
    }
}
