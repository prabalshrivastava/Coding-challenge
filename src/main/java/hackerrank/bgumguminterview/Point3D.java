package hackerrank.bgumguminterview;

public class Point3D extends Point2D {
    int z;
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public double dist3D(Point3D p2) {
        int x1 = p2.x - x;
        int y1 = p2.y - y;
        int z1 = p2.z - z;
        int sum = x1 + y1 + z1;
        return Math.sqrt(sum);
    }
}
