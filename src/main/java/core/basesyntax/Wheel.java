package core.basesyntax;

public class Wheel implements Cloneable {
    private int radius;

    //implement this class
    public Wheel(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Wheel clone() {
        try {
            Wheel newWheel = (Wheel) super.clone();
            return newWheel;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public int hashCode() {
        int hash = 17;
        hash = hash * 31 + radius;
        return hash;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj instanceof Wheel) {
            Wheel current = (Wheel) obj;
            return this.getRadius() == current.getRadius();
        }
        return false;
    }

    @Override
    public String toString() {
        return "Wheel{"
            + "radius=" + radius
            + '}';
    }
}
