package by.matrosov.lesson02;

public class Bar implements Collider{






    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Bar bar = (Bar) obj;
        return true;
    }


    @Override
    public boolean isColliding(Collider other) {
        return false;
    }
}
