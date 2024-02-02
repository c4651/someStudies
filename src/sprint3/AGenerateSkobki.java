package sprint3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class AGenerateSkobki {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            String prefix;
            if (n > 0) {
                prefix = "(";
                generate(n * 2 - 1, prefix, 1, 0, n);
            }
        }
    }

    public static void generate(int n, String prefix, int open, int close, int maxOpen) throws IOException {
        if (n == 0) {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            writer.write(String.valueOf(prefix));
            writer.write("\n");
            writer.flush();
        } else if (open == maxOpen) {
            generate(n - 1, prefix + ")", open, close + 1, maxOpen);
        } else if (close > 0 && close < open) {
            generate(n - 1, prefix + "(", open + 1, close, maxOpen);
            generate(n - 1, prefix + ")", open, close + 1, maxOpen);
        } else {
            generate(n - 1, prefix + "(", open + 1, close, maxOpen);
            if (close < open) {
                generate(n - 1, prefix + ")", open, close + 1, maxOpen);
            }
        }
    }
}
