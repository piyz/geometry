package by.matrosov.lesson02;

public class Bar implements Collider{

    private Point point1;
    private Point point2;

    Bar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {
        this.point1 = new Point(firstCornerX, firstCornerY);
        this.point2 = new Point(secondCornerX, secondCornerY);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Bar bar = (Bar) obj;
        return  this.point1.equals(bar.point1) && this.point2.equals(bar.point2) ||
                this.point1.equals(bar.point2) && this.point2.equals(bar.point1) ||
                this.point1.equals(new Point(bar.point2.getX(), bar.point1.getY())) && this.point2.equals(new Point(bar.point1.getX(), bar.point2.getY())) ||
                this.point1.equals(new Point(bar.point1.getX(), bar.point2.getY())) && this.point2.equals(new Point(bar.point2.getX(), bar.point1.getY()));
    }

    @Override
    public boolean isColliding(Collider other) {
        if (this.equals(other)) return true;

        if (other instanceof Bar){
            Bar bar = (Bar) other;
            return this.equals(bar) ||
            (bar.point1.getX() <= this.point2.getX() && bar.point2.getX() >= this.point1.getX()) &&
                    (bar.point1.getY() <= this.point2.getY() && bar.point2.getY() >= this.point1.getY());
        }

        if (other instanceof Point){
            Point point = (Point) other;
            return point.getX() <= this.getMaxX() && point.getX() >= this.getMinX()
                    && point.getY() >= this.getMinY() && point.getY() <= this.getMaxY();
        }

        return false;
    }

    private int getMaxX(){
        int a = point1.getX();
        int b = point2.getX();
        return (a > b) ? a : b;
    }

    private int getMinX(){
        int a = point1.getX();
        int b = point2.getX();
        return (a < b) ? a : b;
    }

    private int getMaxY(){
        int a = point1.getY();
        int b = point2.getY();
        return (a > b) ? a : b;
    }

    private int getMinY(){
        int a = point1.getX();
        int b = point2.getX();
        return (a < b) ? a : b;
    }
}
