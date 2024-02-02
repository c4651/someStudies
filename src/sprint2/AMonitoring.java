package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AMonitoring {
    public static void main(String[] args) throws IOException {
        int n, m;
        int[][] matrix;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<Integer> arr;
            n = Integer.parseInt(reader.readLine().strip());
            m = Integer.parseInt(reader.readLine().strip());
            matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                arr = Arrays.asList(reader.readLine().strip().split(" "))
                        .stream()
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = arr.get(j);
                }
            }
        }

        transposeMatrix(matrix, n, m);
    }

    static void transposeMatrix(int[][] matrix, int n, int m) {
        int[][] result = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
