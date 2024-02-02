package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JFactorizaciya {
    public static void main(String[] args) throws IOException {
        int x;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            x = Integer.parseInt(reader.readLine().strip());
        }
        factorizacia(x);
    }

    static void factorizacia(int n) {
        StringBuilder result = new StringBuilder();
        int i = 2;
        while (n > 1) {
            if (n % i == 0) {
                n /= i;
                result.append(i).append(" ");
            } else {
                i++;
            }
        }
        System.out.println(result);
    }
}
