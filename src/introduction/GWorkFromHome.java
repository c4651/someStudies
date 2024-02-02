package introduction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GWorkFromHome {
    public static void main(String[] args) throws IOException {
        int n;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().strip());
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(toBinary(n));
        writer.flush();
    }

    static String toBinary(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            stringBuilder.append(n % 2);
            n /= 2;
        }
        return stringBuilder.reverse().toString();
    }
}
