package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HBinarySystem {
    public static void main(String[] args) throws IOException {
        char[] firstNumber;
        char[] secondNumber;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            firstNumber = reader.readLine().trim().toCharArray();
            secondNumber = reader.readLine().trim().toCharArray();
        }
        aaaAAAaaaAAA(firstNumber, secondNumber);
    }

    static void aaaAAAaaaAAA(char[] firstNumber, char[] secondNumber) {
        if (firstNumber.length > secondNumber.length) {
            char[] numbers = new char[firstNumber.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = '0';
            }
            int k = firstNumber.length - 1;
            for (int i = secondNumber.length - 1; i >= 0; i--) {
                numbers[k] = secondNumber[i];
                k--;
            }
            secondNumber = Arrays.copyOf(numbers, numbers.length);

        } else if (secondNumber.length > firstNumber.length) {
            char[] numbers = new char[secondNumber.length];
            for (int i = 0; i < numbers.length; i++) {
                numbers[i] = '0';
            }
            int k = secondNumber.length - 1;
            for (int i = firstNumber.length - 1; i >= 0; i--) {
                numbers[k] = firstNumber[i];
                k--;
            }
            firstNumber = Arrays.copyOf(numbers, numbers.length);
        }

        StringBuilder stringBuilder = new StringBuilder();
        int addSum = 0;
        for (int i = firstNumber.length - 1; i >= 0; i--) {
            switch (Character.digit(firstNumber[i], 10) + Character.digit(secondNumber[i], 10) + addSum) {
                case (3):
                    addSum = 1;
                    stringBuilder.append(1);
                    break;
                case (2):
                    addSum = 1;
                    stringBuilder.append(0);
                    break;
                case (1):
                    addSum = 0;
                    stringBuilder.append(1);
                    break;
                case (0):
                    addSum = 0;
                    stringBuilder.append(0);
                    break;
            }
        }
        if (addSum == 1) {
            stringBuilder.append(addSum);
        }
        System.out.println(stringBuilder.reverse());
    }
}
