package ru.itmo.spaceMarine;

/**
 * X-Y coordinates.
 */
public class Coordinates {
    private Float x;
    private double y;

    public Coordinates(Float x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * @return X-coordinate.
     */
    public Float getX() {
        return x;
    }

    /**
     * @return Y-coordinate.
     */
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "X:" + x + " Y:" + y;
    }

    @Override
    public int hashCode() {
        return x.hashCode() + (int) y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Coordinates) {
            Coordinates coordinatesObj = (Coordinates) obj;
            return (y == coordinatesObj.getY()) && x.equals(coordinatesObj.getX());
        }
        return false;
    }
}

