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

public class SkolzysheeSrednee {
    public static void main(String[] args) throws IOException {
        List<Double> result = new LinkedList<>();
        List<Double> timeseries;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            timeseries = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            int k = Integer.parseInt(reader.readLine().strip());

            double current_sum = 0;
            for (int i = 0; i < k; i++) {
                current_sum += timeseries.get(i);
            }
            result.add(current_sum / k);
            for (int i = 0; i < n - k; i++) {
                current_sum -= timeseries.get(i);
                current_sum += timeseries.get(i + k);
                result.add(current_sum / k);
            }
        }

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (double avg : result) {
            writer.write(String.valueOf(avg));
            writer.write(" ");
        }
        writer.flush();
    }
}
