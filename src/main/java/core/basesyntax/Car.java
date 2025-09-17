package core.basesyntax;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Make this class immutable. See requirements in task description.
 */
public final class Car {
    private final int year;
    private final String color;
    private final List<Wheel> wheels;
    private final Engine engine;

    public Car(int year, String color, List<Wheel> wheels, Engine engine) {
        List<Wheel> newWheels = cloneList(wheels);
        this.year = year;
        this.color = color;
        this.wheels = newWheels;
        this.engine = engine == null ? null : engine.clone();
    }

    public Engine getEngine() {
        return engine.clone();
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public List<Wheel> getWheels() {
        return cloneList(wheels);
    }

    public Car changeEngine(Engine newEngine) {
        if (newEngine == null) {
            throw new NullPointerException();
        }
        List<Wheel> newWheels = cloneList(this.wheels);
        return new Car(year, color, newWheels, newEngine);
    }

    public Car changeColor(String newColor) {
        if (newColor == null) {
            throw new NullPointerException();
        }
        List<Wheel> newWheels = cloneList(this.wheels);
        return new Car(year, newColor, newWheels, engine.clone());
    }

    public Car addWheel(Wheel newWheel) {
        if (newWheel == null) {
            throw new NullPointerException();
        }
        List<Wheel> newWheels = cloneList(this.wheels);
        newWheels.add(newWheel);
        return new Car(year, color, newWheels, engine.clone());
    }

    private List<Wheel> cloneList(List<Wheel> wheels) {
        List<Wheel> list = new ArrayList<>();
        for (Wheel wheel : wheels) {
            list.add(wheel.clone());
        }
        return list;
    }

    public int hashCode(Car other) {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + (color == null ? 0 : color.hashCode());
        result = 31 * result + (wheels == null ? 0 : wheels.hashCode());
        result = 31 * result + (engine == null ? 0 : engine.hashCode());
        return result;
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other == this) {
            return true;
        }

        if (other instanceof Car) {
            Car current = (Car) other;
            return Objects.equals(current.engine, engine) && Objects.equals(current.color, color)
                    && Objects.equals(current.wheels, wheels) && Objects.equals(current.year, year);
        }
        return false;
    }

    @Override
    public String toString() {
        return "Car{"
            + "year=" + year
            + ", color='" + color + '\''
            + ", wheels=" + wheels
            + ", engine=" + engine
            + '}';
    }
}
