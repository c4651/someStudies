package trenirovki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DAnangramma {
    public static void main(String[] args) throws IOException {
        String word1, word2;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            word1 = reader.readLine().strip();
            word2 = reader.readLine().strip();
            System.out.println(check(word1, word2));
        }
    }

    public static String check(String word1, String word2) {
        char[] firstWord = word1.toCharArray();
        char[] secondWord = word2.toCharArray();
        HashMap<String, Integer> first = new HashMap<>();
        HashMap<String, Integer> second = new HashMap<>();
        String temp;
        for (char i : firstWord) {
            temp = String.valueOf(first.get(String.valueOf(i)));
            if (temp.equals("null")) {
                first.put(String.valueOf(i), 1);
            } else {
                first.put(String.valueOf(i), first.get(String.valueOf(i)) + 1);
            }
        }
        for (char i : secondWord) {
            temp = String.valueOf(second.get(String.valueOf(i)));
            if (temp.equals("null")) {
                second.put(String.valueOf(i), 1);
            } else {
                second.put(String.valueOf(i), second.get(String.valueOf(i)) + 1);
            }
        }
        if (first.equals(second)) {
            return "YES";
        }
        return "NO";
    }
}
