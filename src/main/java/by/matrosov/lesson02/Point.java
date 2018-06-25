package by.matrosov.lesson02;

public class Point implements Collider{




    /**
     * @param o - other object to check equality with
     * @return true if two points are equal and not null.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;
        return true;
    }

    @Override
    public boolean isColliding(Collider other) {
        return false;
    }
}
