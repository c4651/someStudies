package testTasks;

import java.util.Arrays;
import java.util.Scanner;

public class ZastegkaMolny {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] result = new int[2 * n];
        for (int i = 0; i < n; i++) {
            result[i * 2] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            result[i * 2 + 1] = scanner.nextInt();
        }
        for (int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }

    }
}
