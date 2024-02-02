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


public class Solution {
    public static void main(String[] args) throws IOException {
        int[] array;
        int[] result;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine().strip());
            String[] strArr = reader.readLine().trim().split(" ");
            array = new int[n];
            for (int j = 0; j < n; j++) {
                array[j] = Integer.parseInt(strArr[j]);
            }
            result = quickSort(array);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i : result) {
            writer.write(String.valueOf(i));
            writer.write(" ");
        }
        writer.flush();
    }

    public static int[] partition(int[] array, int x) {
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
        List<Integer> a = new ArrayList<>();
        a.addAll(left);
        a.addAll(center);
        a.addAll(rigth);
        int[] result = new int[a.size() + 2];
        for (int i = 0; i < a.size(); i++) {
            result[i] = a.get(i);
        }
        result[a.size()] = left.size();
        result[a.size() + 1] = left.size() + center.size();
        return result;
    }

    public static int[] concatenate(int[] a, int[] b, int[] c) {
        int[] result = Arrays.copyOf(a, a.length + b.length + c.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        System.arraycopy(c, 0, result, a.length + b.length, c.length);
        return result;
    }

    public static int[] quickSort(int[] array) {
        if (array.length < 2) {
            return array;
        } else {
            Random random = new Random();
            int pivot = array[random.nextInt(array.length)];
            int[] parts = partition(array, pivot);
            int indexLeft = parts[parts.length - 2];
            int indexCenter = parts[parts.length - 1];
            int[] leftPart = Arrays.copyOfRange(parts, 0, indexLeft);
            int[] rigthPart = Arrays.copyOfRange(parts, indexCenter, parts.length - 2);
            int[] center = Arrays.copyOfRange(parts, indexLeft, indexCenter);
            return concatenate(quickSort(leftPart), center, quickSort(rigthPart));
        }
    }
}
