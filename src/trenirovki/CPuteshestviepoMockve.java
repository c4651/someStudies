package trenirovki;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CPuteshestviepoMockve {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String[] str = reader.readLine().trim().split(" ");
            int ax = Integer.parseInt(str[0]);
            int ay = Integer.parseInt(str[1]);
            int bx = Integer.parseInt(str[2]);
            int by = Integer.parseInt(str[3]);
            minimumDistance(ax, ay, bx, by);
        }
    }

    public static void minimumDistance(int aX, int aY, int bX, int bY) {
        //переписать с BigDecimal
        double aR = Math.sqrt(aX * aX + aY * aY);
        double bR = Math.sqrt(bX * bX + bY * bY);
        double sumR = aR + bR;
        double r1, r2;
        if (aR < bR) {
            r1 = aR;
            r2 = bR;
        } else {
            r1 = bR;
            r2 = aR;
        }
        var angleA = 180 * Math.atan2(aX, aY) / Math.PI;
        var angleB = 180 * Math.atan2(bX, bY) / Math.PI;
        double angle = Math.abs(angleA - angleB);
        if (angle > 180) {
            angle = 360 - angle;
        }
        double l = (angle / 360) * 2 * Math.PI * r1;
        double sumRL = (r2 - r1) + l;
        String result;
        if (sumRL > sumR) {
            result = String.format("%.12f%n", sumR).replace(',', '.');
        } else {
            result = String.format("%.12f%n", sumRL).replace(',', '.');
        }
        System.out.println(result);
    }
}
