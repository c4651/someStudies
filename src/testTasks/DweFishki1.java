package testTasks;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class DweFishki1 {
    public static void main(String[] args) throws IOException {
        List<Integer> arr;
        List<Integer> result = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            arr = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int k = Integer.parseInt(reader.readLine().strip());
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (arr.get(i) + arr.get(j) == k) {
                        result.add(arr.get(i));
                        result.add(arr.get(j));
                    }
                }
            }
        }
        if (result.isEmpty()) {
            System.out.println("None");
        } else {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
            writer.write(String.valueOf(result.get(0)));
            writer.write(" ");
            writer.write(String.valueOf(result.get(1)));
            writer.flush();
        }
    }
}
