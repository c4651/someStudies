package sprint3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LDvaVelosipeda {
    public static void main(String[] args) throws IOException {
        StringBuilder answer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            List<Integer> arr = Arrays.asList(reader.readLine().strip().split(" "))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            Integer[] moneybox = arr.stream().toArray(Integer[]::new);
            int price = Integer.parseInt(reader.readLine().strip());
            answer.append(binarySearch(moneybox, price, 0, moneybox.length) + " ");
            answer.append(binarySearch(moneybox, price * 2, 0, moneybox.length));

        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(String.valueOf(answer));
        writer.flush();
    }

    public static int binarySearch(Integer[] arr, int x, int left, int right) {
        if (right <= left && left != 0) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (arr[mid] >= x && (mid == 0 || arr[mid - 1] < x)) {
            return mid + 1;
        } else if (x <= arr[mid]) {
            return binarySearch(arr, x, left, mid);
        } else {
            return binarySearch(arr, x, mid + 1, right);
        }
    }
}
