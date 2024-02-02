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

public class DweFishki2 {
    public static void main(String[] args) throws IOException {
        List<Integer> arr;
        List<Integer> result = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            arr = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            int k = Integer.parseInt(reader.readLine().strip());
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int current_sum = arr.get(left) + arr.get(right);
                if (current_sum == k) {
                    result.add(arr.get(left));
                    result.add(arr.get(right));
                    break;
                } else if (current_sum < k) {
                    left += 1;
                } else {
                    right -= 1;
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
