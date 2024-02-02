package introduction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class AZnachenyFunc {
    public static void main(String[] args) throws IOException {
        List<Integer> arr = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            arr = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        }
        int[] startTime = new int[4];
        for (int i : startTime) {
            i = i * i;
        }
        int result = calculateFunctionValue(arr.get(0), arr.get(1), arr.get(2), arr.get(3));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(result));
        writer.flush();
        test1();
        test2();
    }

    public static int calculateFunctionValue(int a, int x, int b, int c) {
        return (a * x * x) + (b * x) + c;
    }

    public static void test1() {
        System.out.println();
        if (calculateFunctionValue(-8, -5, -2, 7) == -183) {
            System.out.println("test1 run successful");
        } else {
            System.out.println("test1 fail");
        }
    }
    public static void test2() {
        if (calculateFunctionValue(-8, 0, -2, 7) == 7) {
            System.out.println("test2 run successful");
        } else {
            System.out.println("test2 fail");
        }
    }
}
