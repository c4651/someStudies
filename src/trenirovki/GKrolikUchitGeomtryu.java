package trenirovki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GKrolikUchitGeomtryu {
    public static void main(String[] args) throws IOException {
        int[][] array;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            int m = Integer.parseInt(reader.readLine().strip());
            array = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] strArr = reader.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    array[i][j] = Integer.parseInt(strArr[j]);
                }
            }
        }
    }
}
