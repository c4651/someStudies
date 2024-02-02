package sprint2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class RecursiaFibonache {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = reader.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            BigInteger x = func(n, k);
            System.out.println("func = " + x);
            //System.out.println("k = " + Math.pow(10, k));
            //if (x.compareTo(BigInteger.valueOf((long) Math.pow(10, k))) >= 0) {
                String str = "";
                str += x.mod(BigInteger.valueOf((long) Math.pow(10, k)));
                System.out.println(str);

                /*String s[] = new String[k];
                for (int i = 0; i < k; i++) {
                    s[i] = "" + x.mod(new BigInteger("10"));
                    x = x.divide(new BigInteger("10"));
                }
                for (int i = k - 1; i >= 0; i--) {
                    System.out.print(s[i]);
                }*/

           // } else {
           //     System.out.println(x);
          //  }

        }
    }

    public static BigInteger func(int n, int k) {
        if (n == 1 || n == 0) {
            return new BigInteger("1");
        }
        //List<BigInteger> funcValue = new ArrayList<>();
        BigInteger[] funcValue = new BigInteger[n + 1];
        funcValue[0] = new BigInteger("1");
        funcValue[1] = new BigInteger("1");
        for (int i = 2; i <= n; i++) {
            funcValue[i] = (funcValue[i-1].add(funcValue[i-2])).mod(BigInteger.valueOf((long) Math.pow(10, k)));
        }
        /*BigInteger f0 = new BigInteger("1");
        BigInteger f1 = new BigInteger("1");
        BigInteger current_sum = new BigInteger("0");
        for (int i = 2; i <= n; i++) {
            current_sum = f0.add(f1);
            f0 = f1;
            f1 = current_sum;
        }
        return current_sum;*/
        return funcValue[n];
    }
}