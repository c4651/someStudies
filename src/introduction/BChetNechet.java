package introduction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BChetNechet {
    public static void main(String[] args) throws IOException {
        List<Integer> arr;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            arr = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        String result = checkParityMatch(arr.get(0), arr.get(1), arr.get(2));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(result);
        writer.flush();
    }

    static String checkParityMatch(int a, int b, int c) {
        if (((a % 2 == 0) & (b % 2 == 0)) & (c % 2 == 0)) {
            return "WIN";
        } else if (((a % 2 != 0) & (b % 2 != 0)) & (c % 2 != 0)) {
            return "WIN";
        }
        return "FAIL";
    }
}
