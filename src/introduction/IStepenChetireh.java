package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IStepenChetireh {
    public static void main(String[] args) throws IOException {
        int x;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            x = Integer.parseInt(reader.readLine().strip());
        }
        checkPowOfFour(x);
    }

    static void checkPowOfFour(int x) {
        if (x == 0) {
            System.out.println("False");
            return;
        }
        if (x % 4 == 0 || x == 1) {
            while (x % 4 == 0) {
                x /= 4;
            }
            if (x == 1) {
                System.out.println("True");
            } else {
                System.out.println("False");
            }
        } else {
            System.out.println("False");
        }
    }

}
