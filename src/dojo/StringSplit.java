package dojo;

import java.util.ArrayList;
import java.util.List;

public class StringSplit {
    public static void main(String[] args) {
        String s = "abcd";
        List<String> resultList = new ArrayList<>();
        System.out.println(s.length());
        int index = 0;
        int i = 0;
        while (index < s.length() - 1) {
            resultList.add(i, s.charAt(index) + String.valueOf(s.charAt(index + 1)));
            index+=2;
            i++;
        }
        if (s.length() % 2 != 0) {
            resultList.add(i,s.charAt(index) + "_");
        }
        String[] result = new String[resultList.size()];
        for (int in = 0; in < result.length; in++) {
            result[in] = resultList.get(in);
        }
    }
}
