package hackerrank.bgumguminterview;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Point2D {

    protected int y;
    protected int x;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void printDistance(double d2) {
        DecimalFormat decimalFormat = new DecimalFormat("0");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        System.out.println(decimalFormat.format(d2));
    }

    public double dist2D(Point2D p2) {
        int x1 = p2.x - x;
        int y1 = p2.y - y;
        int sum = x1 + y1;
        return Math.sqrt(sum);
    }
}
