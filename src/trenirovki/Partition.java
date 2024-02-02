package trenirovki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Partition {
    public static void main(String[] args) throws IOException {
        List<Integer> array;
        List<Integer> result;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            array = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            result = quickSort(array);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : result) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }

    public static List<Integer>[] partition(List<Integer> array, int x) {
        List<Integer> left = new ArrayList<>();
        List<Integer> center = new ArrayList<>();
        List<Integer> rigth = new ArrayList<>();
        for (int i : array) {
            if (i < x) {
                left.add(i);
            } else if (i == x) {
                center.add(i);
            } else {
                rigth.add(i);
            }
        }
        return new List[]{left, center, rigth};
    }

    public static List<Integer> quickSort(List<Integer> array) {
        if (array.size() < 2) {
            return array;
        } else {
            Random random = new Random();
            int x = array.get(random.nextInt(array.size()));
            List<Integer>[] parts = partition(array, x);
            return concatenate(quickSort(parts[0]), parts[1], quickSort(parts[2]));
        }
    }

    public static List<Integer> concatenate(List<Integer> a, List<Integer> b, List<Integer> c) {
        List<Integer> result = new ArrayList<>(a.size() + b.size() + c.size());
        result.addAll(a);
        result.addAll(b);
        result.addAll(c);
        return result;
    }
}
