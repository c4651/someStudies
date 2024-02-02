package easyLeet;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
    public static void main(String[] args) {
        int[] array = {0,1,2,4,5,7};
        int[] array2 = {0, 2, 3, 4, 6, 8, 9, 10};
        int[] array3 = {};
        int[] array4 = {1,3};
        System.out.println(summaryRanges(array));
        System.out.println(summaryRanges(array2));
        System.out.println(summaryRanges(array3));
        System.out.println(summaryRanges(array4));
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList();
        if (nums.length > 0) {
            int startRange = nums[0];
            int endRange = nums[0];
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] + 1 != nums[i + 1]) {
                    if (endRange == startRange) {
                        result.add(String.valueOf(endRange));
                        startRange = endRange = nums[i + 1];
                    } else {
                        result.add(startRange + "->" + endRange);
                        startRange = endRange = nums[i + 1];
                    }
                } else {
                    endRange = nums[i + 1];
                }
            }
            if (endRange == startRange) {
                result.add(String.valueOf(endRange));
            } else {
                result.add(startRange + "->" + endRange);
            }
        }
        return result;


        /*List<String> al = new ArrayList();
        for(int i = 0; i < nums.length; i++) {
            int a = nums[i];
            while(i < nums.length - 1 && nums[i] + 1 == nums[i+1]) {
                i++;
            }
            if(a == nums[i]) {
                al.add("" + nums[i]);
            } else {
                al.add(a + "->" + nums[i]);
            }
        }
        return al; */
    }
}
