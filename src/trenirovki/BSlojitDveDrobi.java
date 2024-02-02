package trenirovki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BSlojitDveDrobi {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = reader.readLine().trim().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int c = Integer.parseInt(str[2]);
            int d = Integer.parseInt(str[3]);
            sum(a, b, c, d);
        }
    }

    public static void sum(int a, int b, int c, int d) {
        int m = (a * d) + (b * c);
        int n = b * d;
        int nod = nod(m, n);
        System.out.println(m / nod + " " + n / nod);
    }

    public static int nod(int m, int n) {
        while (m != 0 && n != 0) {
            if (m > n) {
                m = m % n;
            } else {
                n = n % m;
            }
        }
        return (n + m);
    }
}
