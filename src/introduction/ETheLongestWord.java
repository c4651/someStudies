package introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ETheLongestWord {
    public static void main(String[] args) throws IOException {
        int n;
        String[] words;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            n = Integer.parseInt(reader.readLine().strip());
            words = reader.readLine().trim().split(" ");
        }
        theLongestWord(words);
    }

    static void theLongestWord(String[] words) {
        int max = 0;
        int iMax = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > max) {
                max = words[i].length();
                iMax = i;
            }
        }
        System.out.println(words[iMax]);
        System.out.println(max);
    }
}