package by.matrosov.lesson02;

public class Point implements Collider{

    private int x;
    private int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;
        return this.x == point.x && this.y == point.y;
    }

    @Override
    public boolean isColliding(Collider other) {
        if (this.equals(other)) return true;

        if (other instanceof Point){
            Point point = (Point) other;
            return this.equals(point);
        }

        return false;
    }
}
