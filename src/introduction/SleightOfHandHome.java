//92580338
package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SleightOfHandHome {
    public static void main(String[] args) throws IOException {
        char[][] array = new char[4][4];
        int k;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            k = Integer.parseInt(reader.readLine().strip());
            for (int i = 0; i < array.length; i++) {
                array[i] = reader.readLine().trim().toCharArray();
            }
        }
        solution(array, k);
    }

    static void solution(char[][] array, int k) {
        int t = 1;
        int result = 0;
        while (t <= 9) {
            result += round(array, k, t);
            t++;
        }
        System.out.println(result);
    }

    static int round(char[][] array, int k, int t) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (Character.getNumericValue(array[i][j]) == t) {
                    count++;
                }
            }
        }
        if (count <= k * 2 && count > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
