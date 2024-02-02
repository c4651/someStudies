package introduction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSosedi {
    public static void main(String[] args) throws IOException {
        int[][] array;
        int x, y;
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
            x = Integer.parseInt(reader.readLine().strip());
            y = Integer.parseInt(reader.readLine().strip());

        }
        List<Integer> result = searchForNeighbors(array, x, y);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : result) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }

    static List<Integer> searchForNeighbors(int[][] array, int x, int y) {
        List<Integer> result = new ArrayList<>();
        if (x < array.length - 1) {
            result.add(array[x + 1][y]);
        }
        if (y < array[0].length - 1) {
            result.add(array[x][y + 1]);
        }
        if (x > 0) {
            result.add(array[x - 1][y]);
        }
        if (y > 0) {
            result.add(array[x][y - 1]);
        }
        return result.stream().sorted().collect(Collectors.toList());
    }
}
