package introduction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FPalindrom {
    public static void main(String[] args) throws IOException {
        String word;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            word = reader.readLine().strip().toLowerCase();
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(isPalindrome(word));
        writer.flush();
    }

    static String isPalindrome(String word) {
        String str = new StringBuilder(word.replaceAll("[^A-Za-z0-9]", "")).reverse().toString();
        System.out.println(str);
        if (str.equals(word.replaceAll("[^A-Za-z0-9]", ""))) {
            return "True";
        }
        return "False";
    }
}
