package InterfaceExample;

public interface Distance {
    // Compute the distance between the current point and p
    double get(Point point);

    static double get(Point p1, Point p2) {
        return p1.get(p2);
    }
}
